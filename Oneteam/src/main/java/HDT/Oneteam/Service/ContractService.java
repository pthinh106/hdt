package HDT.Oneteam.Service;

import HDT.Oneteam.Model.*;
import HDT.Oneteam.Repository.BEProductDetailsReps;
import HDT.Oneteam.Repository.BExportProductReps;
import HDT.Oneteam.Repository.ContractDetailsReps;
import HDT.Oneteam.Repository.ContractReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ContractService {
    @Autowired
    private ContractReps contractReps;
    @Autowired
    private ContractDetailsReps contractDetailsReps;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BEProductDetailsReps bEProductDetailsReps;
    @Autowired
    private BExportProductReps bExportProductReps;


    ///module
    public List<Contract> getAll(){
        return contractReps.findAll();
    }
    public List<Contract> getContractByStatus(int status){
        return contractReps.findAllByStatus(status);
    }
    public List<Contract> getContractByStatusAndLiquidationStatusIn(int status, Collection<Integer> liquidationStatus){
        List<Contract> contractList = contractReps.findAllByStatusOrderByUpdatedAsc(0);
        for(Contract contract : contractList){
            if(contract.getLiquidationStatus() == 2){
                continue;
            }else{
                List<ContractDetails> contractDetailsList = contractDetailsReps.findAllByContract(contract);
                for(ContractDetails contractDetails : contractDetailsList){
                    if(contractDetails.getQuantity() > contractDetails.getProduct().getInventoryV1()){
                        contract.setLiquidationStatus(0);
                        break;
                    }else{
                        contract.setLiquidationStatus(1);
                    }
                }
                if(contract.getLiquidationStatus() == 1){
                    for(ContractDetails contractDetails : contractDetailsList){
                        Product product = new Product();
                        product = productService.getProductById(contractDetails.getProduct().getProductId());
                        product.setInventoryV1(product.getInventoryV1() - contractDetails.getQuantity());
                        productService.save(product);
                    }
                }else{
                    if(contract.getLiquidationStatus() == 0){
                        break;
                    }
                }
            }
        }
        for(Contract contract : contractList){
            if(contract.getLiquidationStatus() != 2){
                List<ContractDetails> contractDetailsList = contractDetailsReps.findAllByContract(contract);
                for(ContractDetails contractDetails : contractDetailsList){
                    Product product = new Product();
                    product = productService.getProductById(contractDetails.getProduct().getProductId());
                    product.setInventoryV1(product.getInventoryV2());
                    productService.save(product);
                }
            }
        }
        contractReps.saveAll(contractList);

        return contractReps.findAllByStatusAndLiquidationStatusInOrderByUpdatedAsc(status,liquidationStatus);
    }
    public List<Contract> getContractByStatusAndLiquidationStatus(int status,int liquidationStatus){
        return contractReps.findAllByStatusAndLiquidationStatus(status,liquidationStatus);
    }

    public Contract getContractById(int contractId){
        return contractReps.findById(contractId).get();
    }
    public List<ContractDetails> getListContractDetailsByContract(Contract contract){
        return contractDetailsReps.findAllByContract(contract);
    }

    public Boolean liquidationRequest(int contractId){
        Optional<Contract> contract = contractReps.findById(contractId);
        if(contract.isPresent()){
            contract.get().setLiquidationStatus(2);
            for(ContractDetails contractDetails : contract.get().getContractDetailsList()){
                Product product = new Product();
                product = productService.getProductById(contractDetails.getProduct().getProductId());
                product.setInventoryV1(product.getInventoryV1() - contractDetails.getQuantity());
                product.setInventoryV2(product.getInventoryV1());
                productService.save(product);
            }
            contractReps.save(contract.get());
            return true;
        }else{
            return false;
        }
    }
    public Boolean liquidationContract(String listContractId){
        Collection<Integer> listContractIdCol = new ArrayList<>();
        String[] listId = listContractId.split(",");
        for(int i = 0 ; i < listId.length; i++){
            listContractIdCol.add(Integer.parseInt(listId[i]));
        }
        List<Contract> contractList = contractReps.findAllByContractIdIn(listContractIdCol);

        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                BillExportProduct billExportProduct = new BillExportProduct();
                billExportProduct.setContract(contract);
                billExportProduct.setStatus(1);
                try {
                    bExportProductReps.save(billExportProduct);
                }catch (Exception e){
                    return false;
                }
                List<ContractDetails> contractDetailsList = getListContractDetailsByContract(contract);
                for(ContractDetails contractDetails : contractDetailsList){
                    BillExportProductDetails billExportProductDetails = new BillExportProductDetails();
                    billExportProductDetails.setBillExportProduct(billExportProduct);
                    billExportProductDetails.setProduct(contractDetails.getProduct());
                    billExportProductDetails.setQuantity(contractDetails.getQuantity());
                    billExportProductDetails.setTotal(contractDetails.getTotal());
                    try {
                        bEProductDetailsReps.save(billExportProductDetails);
                    }catch (Exception e){
                        return false;
                    }
                    Product product = new Product();
                    product = productService.getProductById(contractDetails.getProduct().getProductId());
                    product.setInventory(product.getInventory() - contractDetails.getQuantity());
                    product.setInventoryV1(product.getInventory());
                    product.setInventoryV2(product.getInventory());
                    productService.save(product);

                }
                contract.setStatus(1);
            }
            try {
                contractReps.saveAll(contractList);
            }catch (Exception e){
                return false;
            }
            return true;
        }
        return false;
    }
    public Boolean liquidationContractDontAccept(String listContractId){
        Collection<Integer> listContractIdCol = new ArrayList<>();
        String[] listId = listContractId.split(",");
        for(int i = 0 ; i < listId.length; i++){
            listContractIdCol.add(Integer.parseInt(listId[i]));
        }
        List<Contract> contractList = contractReps.findAllByContractIdIn(listContractIdCol);
        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                contract.setLiquidationStatus(1);
                for (ContractDetails contractDetails : contract.getContractDetailsList()){
                    Product product = new Product();
                    product = productService.getProductById(contractDetails.getProduct().getProductId());
                    product.setInventoryV1(product.getInventory());
                    product.setInventoryV2(product.getInventory());
                    productService.save(product);
                }
            }
            contractReps.saveAll(contractList);
            return true;
        }
        return false;
    }
    public Boolean createContract(Contract contract,int[] productDetailsId, int[] productQuantity,int accountId){
        if(contract.getCustomer().getCustomerName().isEmpty() || contract.getCustomer().getAddress().isEmpty() ||
                contract.getCustomer().getTax().isEmpty() || contract.getCustomer().getPhoneNumber().isEmpty() ||
                contract.getDeliveryPlace().isEmpty() ){
            return false;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date = Date.valueOf(dtf.format(LocalDate.now()));
        if(contract.getUpdated().before(date)){
            return false;
        }
        Customer customer = contract.getCustomer();
        customerService.save(customer);
        contract.setCustomer(customer);
        contract.setEmployee(employeeService.getEmployeeByAccountId(accountId));
        contractReps.save(contract);
        double total = 0;
        for(int i = 0; i <productQuantity.length;i++){
            if(productQuantity[i] == 0){
                continue;
            }
            ContractDetails contractDetails = new ContractDetails();
            contractDetails.setContract(contract);
            contractDetails.setProduct(productService.getProductById(productDetailsId[i]));
            contractDetails.setQuantity(productQuantity[i]);
            contractDetails.setTotal(productService.getProductById(productDetailsId[i]).getPrice()*productQuantity[i]);
            total += contractDetails.getTotal();
            contractDetailsReps.save(contractDetails);
        }
        contract.setTotal(total*1.1);
        contractReps.save(contract);
        return true;
    }
    public Boolean deletecontract(int contractId){
        Optional<Contract> contract = contractReps.findById(contractId);
        if(contract.isPresent()){
            List<ContractDetails>  contractDetailsList = getListContractDetailsByContract(contract.get());
            for(ContractDetails contractDetails : contractDetailsList){
                Product product = new Product();
                product = productService.getProductById(contractDetails.getProduct().getProductId());
                product.setInventoryV1(product.getInventoryV1()+contractDetails.getQuantity());
                try {
                    productService.save(product);
                }catch (Exception e){
                    return false;
                }
            }
            contract.get().setStatus(3);
            contract.get().setLiquidationStatus(0);
            contractReps.save(contract.get());
            return true;
        }else{
            return false;
        }
    }

    public boolean updateContract(Contract contract, int[] productDetailsId, int[] productQuantity, int accountId) {
        if(productQuantity.length < 1){
            return false;
        }
        Optional<Contract> contract1 = contractReps.findById(contract.getContractId());
        if(contract1.isPresent()){
            if(contract.getCustomer().getCustomerName().isEmpty() || contract.getCustomer().getAddress().isEmpty() ||
                    contract.getCustomer().getTax().isEmpty() || contract.getCustomer().getPhoneNumber().isEmpty() ||
                    contract.getDeliveryPlace().isEmpty() ){
                return false;
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date date = Date.valueOf(dtf.format(LocalDate.now()));
            if(contract.getUpdated().before(date)){
                return false;
            }
            Customer customer = contract.getCustomer();
            customerService.save(customer);
            contract1.get().setCustomer(customer);
            contract1.get().setEmployee(employeeService.getEmployeeByAccountId(accountId));
            contract1.get().setUpdated(contract.getUpdated());
            contract1.get().setPayment(contract.getPayment());
            contract1.get().setDeliveryPlace(contract.getDeliveryPlace());
            contract1.get().setProvision(contract.getProvision());
            try {
                contractReps.save(contract1.get());
            }catch (Exception e){
                return false;
            }
            for (ContractDetails contractDetails : contractDetailsReps.findAllByContract(contract1.get())){
                try {
                    contractDetailsReps.delete(contractDetails);
                    System.out.println("success");
                }catch (Exception e){
                    System.out.println("fail");
                }
            }
            double total = 0;
            for(int i = 0; i <productQuantity.length;i++){
                if(productQuantity[i] == 0){
                    continue;
                }
                ContractDetails contractDetails = new ContractDetails();
                contractDetails.setContract(contract1.get());
                contractDetails.setProduct(productService.getProductById(productDetailsId[i]));
                contractDetails.setQuantity(productQuantity[i]);
                contractDetails.setTotal(productService.getProductById(productDetailsId[i]).getPrice()*productQuantity[i]);
                total += contractDetails.getTotal();
                contractDetailsReps.save(contractDetails);
            }
            contract1.get().setTotal(total*1.1);
            contractReps.save(contract1.get());
            return true;
        }else{
            return false;
        }
    }
}

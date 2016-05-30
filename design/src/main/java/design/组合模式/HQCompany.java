package design.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/9 18:06
 * fuquanemail@gmail.com
 */
public class HQCompany extends Company {

    List<Company> companyList= new ArrayList<>();

    public HQCompany(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        companyList.remove(company);
    }

    @Override
    public void show() {
        System.out.println(name);
        for(Company c : companyList){
            c.show();
        }
    }
}

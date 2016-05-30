package design.组合模式.areacompany;

import design.组合模式.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/9 17:58
 * fuquanemail@gmail.com
 */
public class SZCompany extends Company {
    private List<Company> child = new ArrayList<>();

    public SZCompany(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {
        child.add(company);
    }

    @Override
    public void remove(Company company) {
        if(child.contains(company)){
            child.remove(company);
        }
    }

    @Override
    public void show() {
        System.out.println("分公司"+name);
        for(Company c : child){
            c.show();
        }
    }
}

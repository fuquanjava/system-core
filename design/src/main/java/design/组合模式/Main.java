package design.组合模式;

import design.组合模式.areacompany.SHCompany;
import design.组合模式.areacompany.SZCompany;

/**
 * Hello-World 2015/8/9 18:02
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {

        Company root = new HQCompany("总公司");

        Company dept = new Dept("人力部");

        Company sh =new SHCompany("上海");
        Company sz = new SZCompany("深圳");
        root.add(dept);
        root.add(sh);
        root.add(sz);

        sh.add(dept);

        root.show();


    }
}

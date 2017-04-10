package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String ss = "";
        System.err.println(JSON.toJSONString(ss));
        System.err.println(new JSONObject());

        String s  = "极有家、单身贵族、二人世界、家有萌娃、品质好物、潮流酷玩、装备运动、科技前沿、型男风尚、烧友必buy、iFashion、全球时尚、新选大赏、非常大牌";

        String [] ary = s.split("、");



        for(int i = 0 ; i< ary.length; i++){

            String sql = String.format("insert into benefit_scene(gmt_create,  gmt_modified,  status,  operator,  features,  name,  parent_id,  definition) values('2017-03-28 15:13:01', '2017-03-28 15:13:01', 1, '梨白', '{}', '%s', 1, '{}')", ary[i]);

            System.err.println(sql);
        }

//        JSONObject object = new JSONObject();
//        object.put("target","新白领人群月薪2万元以上");
//
//        Indicaotr indicaotr = new Indicaotr();
//        indicaotr.setName("购买力");
//        indicaotr.setId(1L);
//        indicaotr.setGroupId(2L);
//        indicaotr.setData("5");
//        List<Indicaotr> indicaotrs = new ArrayList<>();
//        indicaotrs.add(indicaotr);
//
//        Desc consumer = new Desc();
//        consumer.setDesc("标准描述");
//        consumer.setIndicaotrList(indicaotrs);
//
//
//        Indicaotr indicaotr2 = new Indicaotr();
//        indicaotr2.setName("购买力");
//        indicaotr2.setId(1L);
//        indicaotr2.setGroupId(2L);
//        indicaotr2.setData("5");
//        List<Indicaotr> indicaotrs2 = new ArrayList<>();
//        indicaotrs.add(indicaotr2);
//
//        Desc seller = new Desc();
//        seller.setDesc("商家店铺标准描述");
//        seller.setIndicaotrList(indicaotrs2);
//
//        List<Indicaotr> indicaotrs3 = new ArrayList<>();
//
//        indicaotrs3.add(indicaotr);
//
//        Desc gds = new Desc();
//        gds.setDesc("商品标准描述");
//        gds.setIndicaotrList(indicaotrs3);
//
//        object.put("consumer", consumer);
//        object.put("seller", seller);
//        object.put("gds", gds);
//
//
//        System.err.println(object.toString());

        Indicaotr indicaotr = new Indicaotr();
        indicaotr.setName("购买力");
        indicaotr.setId(1L);
        indicaotr.setGroupId(2L);
        indicaotr.setData("5");
        List<Indicaotr> indicaotrs = new ArrayList<>();
        indicaotrs.add(indicaotr);

        Desc desc = new Desc();

        desc.setType(1);
        desc.setDesc("描述文字");

        Desc desc2 = new Desc();

        desc2.setType(2);
        desc2.setDesc("描述文字2");


        List<Group> groups = new ArrayList<>();

        List<Indicaotr> Indicaotrs = new ArrayList<>();

        for(int i=0; i< 4; i++){
            Indicaotr indicaotr1 = new Indicaotr();
            indicaotr1.setName("购买力"+i);
            indicaotr1.setId((long) i);
            indicaotr1.setGroupId(2L);
            indicaotr1.setData(i+"");

            Indicaotrs.add(indicaotr1);
        }
        Group group = new Group();
        group.setId(2L);
        group.setName("分组名字");
        group.setIndicaotrList(indicaotrs);

        groups.add(group);

        desc2.setGroups(groups);

        List<Desc> list = new ArrayList<>();

        list.add(desc2);
        System.err.println(JSON.toJSONString(list));


    }


    static class Group{
        private Long id;
        private String name;
        List<Indicaotr> indicaotrList;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Indicaotr> getIndicaotrList() {
            return indicaotrList;
        }

        public void setIndicaotrList(List<Indicaotr> indicaotrList) {
            this.indicaotrList = indicaotrList;
        }
    }

    static class Indicaotr {
        String name;
        String data;
        Long id;
        Long groupId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Indicaotr indicaotr = (Indicaotr) o;

            return id != null ? id.equals(indicaotr.id) : indicaotr.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }

    static class Desc{
        String desc;
        int type;

        List<Group> groups;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Desc desc = (Desc) o;

            return type == desc.type;
        }

        @Override
        public int hashCode() {
            return type;
        }
    }

}

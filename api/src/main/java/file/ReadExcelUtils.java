package file;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import benefit.BeidouData;
import benefit.ExportData;
import benefit.QXData;
import benefit.RuleCate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Data;
import poi.ExcelResult;
import poi.ExcelUtil;

/**
 * 读取Excel
 *
 * @author zengwendong
 */
public class ReadExcelUtils {

    static Map<String, BeidouData> beidouDataMap = null;
    static Map<String, QXData> qxDataMap = null;
    static Map<String, RuleCate> ruleDataMap = null;

    static {

        try {
            beidouDataMap = BeidouData.parseBeidou();
            qxDataMap = QXData.parseQX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("beidouDataMap size:::" + beidouDataMap.size());
        System.out.println("qxDataMap size:::" + qxDataMap.size());
        System.out.println("ruleDataMap size:::" + ruleDataMap.size());

        Set<Entry<String, QXData>> set = qxDataMap.entrySet();
        Iterator<Entry<String, QXData>> iterator = set.iterator();

        List<ExportData> exportDatas = Lists.newArrayList();

        while (iterator.hasNext()) {
            Entry<String, QXData> entry = iterator.next();

            QXData qxData = entry.getValue();

            if (qxData.getBizName().equals("plan_pool_industry_scene")) {
                //场景池
                parseScene(qxData, qxDataMap);

                RuleCate ruleCate = ruleDataMap.get(qxData.getL4());

                Set<Long> beidouIds = qxData.getBeidouIds();
                Iterator<Long> ite = beidouIds.iterator();
                while (ite.hasNext()) {
                    Long id = ite.next(); // id 北斗ID
                    BeidouData beidouData = beidouDataMap.get(id.toString());
                    if(beidouData != null && ruleCate != null){

                        ExportData exportData = new ExportData();
                        exportData.setBeidouId(id.toString());
                        exportData.setBeidouName(beidouData.getName());
                        exportData.setBeidouOwner(beidouData.getOwner());
                        exportData.setRuleId(qxData.getL4());
                        exportData.setSceneId(qxData.getL3());

                        exportDatas.add(exportData);
                    }


                }

            }

        }

        System.out.println(exportDatas);
        String file = "/Users/libai/Desktop/规则中心北斗群组关联关系.xlsx";

        ExcelResult excelResult = ExcelUtil.exportExcelWithHeader(file, exportDatas, null, 1, ExportData.class);


    }

    public static void parseScene(QXData obj, Map<String, QXData> map) {
        JSONArray data = JSON.parseArray(obj.getFeature());
        JSONArray array = data.getJSONArray(0);
        for (int i = 0; i < array.size(); i++) {
            JSONObject object = array.getJSONObject(i);
            String name = object.getString("name");
            if (name.equals("品类规划池")) {
                ID idData = object.getObject("value", ID.class);

                if (idData != null) {
                    Set<Long> ids = idData.getYes();

                    for (Long id : ids) {
                        // ID:
                        Set<Long> beidouIds = getBeidouIds(map.get(id.toString()));

                        obj.getBeidouIds().addAll(beidouIds);

                    }

                }
            } else if (name.equals("北斗卖家群组")) {
                Set<Long> beidouIds = getBeidouIds(obj);
                obj.getBeidouIds().addAll(beidouIds);
            }

        }
    }

    @Data
    static class ID implements Serializable {
        private Set<Long> no;
        private Set<Long> yes;

    }

    private static Set<Long> getBeidouIds(QXData obj) {
        if (obj == null) {
            return Sets.newHashSet();
        }
        JSONArray data = JSON.parseArray(obj.getFeature());
        JSONArray array = data.getJSONArray(0);
        for (int i = 0; i < array.size(); i++) {
            JSONObject object = array.getJSONObject(i);
            if (object.getString("name").equals("北斗卖家群组")) {
                ID idData = object.getObject("value", ID.class);

                if (idData != null) {

                    return idData.getYes();
                }
            }

        }

        return null;
    }
}
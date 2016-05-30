package design.门面模式;

import design.门面模式.subsystem.BaiduService;
import design.门面模式.subsystem.QQServices;

/**
 * Hello-World 2015/8/8 15:34
 * fuquanemail@gmail.com
 */
public class MapServicesFacadeImpl implements MapServicesFacade {
    @Override
    public void services() {
        BaiduService baiduService = new BaiduService();
        baiduService.services();

        QQServices qqServices = new QQServices();
        qqServices.services();
    }
}

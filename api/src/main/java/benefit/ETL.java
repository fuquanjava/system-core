package benefit;

import java.io.Serializable;

import lombok.Data;

@Data
public class ETL implements Serializable{

    private String bpmId;
    private String creatorId;
    private String creatorName;

    private String logicColCn;
    private String logicColEn;
}

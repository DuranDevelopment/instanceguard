package cc.ddev.instanceguard.data;

import java.io.File;

public class DataManager {
    private String dataPath;






    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getDataPath() {
        return dataPath;
    }

    public File getDataFile() {
        return new File(dataPath);
    }
}

class TimeMap {
    public final Map<String,TreeMap<Integer,String>> historyByKey;
    public TimeMap() {
        historyByKey = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> history = historyByKey.get(key);
        if(history == null){
            history = new TreeMap<>();
            historyByKey.put(key,history);
        }
        history.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> history = historyByKey.get(key);
        if(history == null ){
            return "";
        }

        Map.Entry<Integer,String> entry = history.floorEntry(timestamp);
        if(entry ==null){
            return "";
        }
        return entry.getValue();
    }
}

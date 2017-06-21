package cn.edu.zut.excellent.conf;


public enum Role {
	ADMIN("admin",1),TEA("teacher",2),STU("student",4);

    private String name;
    private int index;

    Role(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "name:" + name +" index:" + index;
    }

    public static Role getName(int index){
        for (Role s : Role.values()){
            if (s.getIndex() == index){
                return s;
            }
        }
        return null;
    }

	public static Role getIndex(String name){
        for (Role s : Role.values()){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

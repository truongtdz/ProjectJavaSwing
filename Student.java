public class Student {
    private String MaSV, Name, Class;
    private Double Gpa;

    public Student(String MaSV, String Name, String Class, Double Gpa){
        this.MaSV = MaSV;
        this.Name = Name;
        this.Class = Class;
        this.Gpa = Gpa;
    }
    public String getMaSV() {
        return MaSV;
    }

    public String getName() {
        return Name;
    }

    public String getClassName(){
        return Class;
    }

    public Double getGpa() {
        return Gpa;
    }

    public void ChuanHoaTen(){
        String[] arr = Name.trim().split("\\s+");
        String str = "";
        for(String s : arr){
            str += Character.toUpperCase(s.charAt(0));
            for(int i = 1; i < s.length(); i++){
                str += Character.toLowerCase(s.charAt(i));
            }
            str += " ";
        }
        Name = str.trim().toString();
    }

    public void ChuanHoaLop(){
        String str = "";
        for(char x : Class.toCharArray()){
            str += Character.toUpperCase(x);
        }
        Class = str.trim().toString();
    }
}

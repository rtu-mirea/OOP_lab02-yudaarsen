import java.lang.StringBuffer;

public class Task2 {
    private StringBuffer data;

    public Task2(String data)
    {
        this.data = new StringBuffer(data);
    }

    public String deleteZero() {
        int pointer = 0;
        int last = data.indexOf(";");
        for(int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == ' ')
                pointer = i;
            else if(data.charAt(i) == ';'){
                if(Integer.parseInt(data.substring(pointer + 1, i)) == 0) {
                    data = data.delete(last + 1, i + 1);
                    i -= (i + 1) - (last + 1);
                }
                else
                    last = i;
            }
        }
        return data.toString();
    }

    public void changeMinToMax(){
        String max = "";
        String min = data.toString();
        int pointer = -1;
        for(int i = 0; i < data.length(); i++) {
             if(data.charAt(i) == ';'){
                 if(data.substring(pointer + 1, i).length() > max.length())
                     max = data.substring(pointer + 1, i);
                 if(data.substring(pointer + 1, i).length() < min.length())
                     min = data.substring(pointer + 1, i);
                 pointer = i;
            }
        }
        System.out.println("Наименьшая продажа по длине: " + min);
        System.out.println("Наибольшая продажа по длине: " + max);
        data = new StringBuffer(data.substring(0, data.indexOf(min + ";")) + max + ";" + data.substring(data.indexOf(min + ";") + (min.length() + 1)));
        System.out.println(data.toString());
    }

    public void addProduct(String prod){
        data.append(prod + ";");
        System.out.println(data.toString());
    }
}

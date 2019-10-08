import java.lang.String;

public class Task1 {
    private String data;

    public Task1(String data)
    {
        this.data = data;
    }

    public int priceSum()
    {
        int spacePointer = 0;
        int result = 0;
        for(int i = 0; i < data.length(); i++)
        {
            if(data.charAt(i) == ' ')
                spacePointer = i;
            else if(data.charAt(i) == ';') {
                result += Integer.parseInt(data.substring(spacePointer + 1, i));
            }
        }
        return result;
    }

    public String chageLetter()
    {
        String str = data;
        for(int i = 1; i < data.length(); i++)
        {
            if(str.charAt(i) == ';' && i != str.length() - 1) {
                str = changeChar(str, i + 1, Character.toLowerCase(str.charAt(i + 1)));
            }
        }
        return str;
    }

    private String changeChar(String str, int index, char symbol) {
        return str.substring(0, index) + symbol + str.substring(index + 1);
    }

    public String topList() {
        String result = "";
        String[] mas = data.split(";");
        int[] counts = new int[mas.length];
        for(int i = 0; i < mas.length; i++)
        {
            mas[i] = mas[i].substring(0, mas[i].indexOf(' ')); // оставляю только массив из названий
        }
        boolean flag;
        for(int i = 0; i < mas.length; i++) {
            flag = false;
            for(int j = i - 1; j > 0; j--)
            {
                if(mas[i].equals(mas[j])) flag = true;
            }
            if(!flag) {
                for (String element : mas) {
                    if (mas[i].equals(element)) counts[i]++;
                }
            }
            else continue;
        }
        for(int i = 1; i < counts.length; i++) { //метод вставок
            for(int j = i; j > 0 && counts[j - 1] < counts[j]; j--) {
                int h = counts[j - 1];
                counts[j - 1] = counts[j];
                counts[j] = h;
                String sh = mas[j - 1];
                mas[j - 1] = mas[j];
                mas[j] = sh;
            }
        }
        for(int i = 0; i < counts.length; i++)
        {
            if(result.indexOf(mas[i]) == -1)
                result += mas[i] + " ";
        }
        return result;
    }

    public String getProduct(int index)
    {
        String[] mas = data.split(";");
        return mas[index];
    }
}

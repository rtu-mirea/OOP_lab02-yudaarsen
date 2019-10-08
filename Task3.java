import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private String data;

    public Task3(String data)
    {
        this.data = data;
    }

    public void isDateFormat()
    {
        Pattern format = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
        Matcher matcher = format.matcher(data);
        if(matcher.find()) {
            if(Integer.parseInt(data.substring(matcher.start(), matcher.start() + 2)) > 0 &&
                    Integer.parseInt(data.substring(matcher.start() + 3, matcher.start() + 5)) > 0 &&
                    Integer.parseInt(data.substring(matcher.start(), matcher.start() + 2)) < 31 &&
                    Integer.parseInt(data.substring(matcher.start() + 3, matcher.start() + 5)) < 31) {
                System.out.println("Строка является датой в русском или американском формате.");
                return;
            }
        }
        System.out.println("Некорректный формат.");
    }

    public void changeFormat(String text) {
        Pattern format = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        Matcher matcher = format.matcher(text);
        String hstr;
        String result = text;
        if(matcher.find())
        {
            do{
                hstr = result.substring(matcher.start() + 3, matcher.start() + 5) + "." +
                        result.substring(matcher.start(), matcher.start() + 2) + "." + result.substring(matcher.start() + 6, matcher.end());
                result = result.substring(0, matcher.start()) + hstr + result.substring(matcher.end());
            }while(matcher.find(matcher.start() + 1));
        }
        System.out.println(result);
    }
}

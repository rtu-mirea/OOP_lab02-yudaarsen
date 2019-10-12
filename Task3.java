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
        Pattern rusFormat = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$"); //"^\\d{2}\\.\\d{2}\\.\\d{4}$"
        Pattern usaFormat = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
        Matcher matcher = rusFormat.matcher(data);
        if(matcher.find()) {
            Pattern rusCheck = Pattern.compile("\\d{2}");
            matcher = rusCheck.matcher(data);
            if(matcher.find() && Integer.parseInt(matcher.group()) > 0 && Integer.parseInt(matcher.group()) <= 31)
            {
                if(matcher.find() && Integer.parseInt(matcher.group()) > 0 && Integer.parseInt(matcher.group()) <= 12)
                {
                    rusCheck = Pattern.compile("\\d{4}$");
                    matcher = rusCheck.matcher(data);
                    if(matcher.find() && Integer.parseInt(matcher.group()) > 0) {
                        System.out.println("Строка является датой в русском формате.");
                        return;
                    }
                }
            }
        }
        else
        {
            matcher = usaFormat.matcher(data);
            Pattern usaCheck = Pattern.compile("\\d{2}");
            matcher = usaCheck.matcher(data);
            if(matcher.find() && Integer.parseInt(matcher.group()) > 0 && Integer.parseInt(matcher.group()) <= 12)
            {
                if(matcher.find() && Integer.parseInt(matcher.group()) > 0 && Integer.parseInt(matcher.group()) <= 31)
                {
                    usaCheck = Pattern.compile("\\d{4}$");
                    matcher = usaCheck.matcher(data);
                    if(matcher.find() && Integer.parseInt(matcher.group()) > 0) {
                        System.out.println("Строка является датой в американском формате.");
                        return;
                    }
                }
            }
        }
        System.out.println("Некорректный формат.");
    }

    public void changeFormat(String text) {
        String result = text;
        result = result.replaceAll("(\\d{2})-(\\d{2})-(\\d{4})", "$2\\.$1\\.$3");
        System.out.println(result);
    }
}

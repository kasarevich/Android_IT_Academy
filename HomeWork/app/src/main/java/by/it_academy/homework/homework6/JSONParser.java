package by.it_academy.homework.homework6;

        import com.google.gson.Gson;
        import org.xml.sax.SAXException;

        import javax.xml.parsers.ParserConfigurationException;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.text.ParseException;

        import by.it_academy.homework.homework6.entity.Station;

public class JSONParser{
    public Station parse(String nameOfFile)throws ParserConfigurationException,
            IOException, ParseException, SAXException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile));
        Station station = gson.fromJson(bufferedReader, Station.class);

        if (station == null){
            throw new SAXException("Не удалось расшифровать файл");
        }
        return station;
    }
}

package com.weather.services;

import com.weather.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService{

    private final Logger logger = LoggerFactory.getLogger(XMLService.class);
    private Forecasts forecasts;
    private Forecast_date forecast_date;
    private Night night;
    private Day day;

    public <Forecast_Date> Forecasts parseForecast() {


        try {
            // end point that returns XML response
            String URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // normalize XML response
            doc.getDocumentElement().normalize();

            //read forecasts details first
            forecasts = new Forecasts(
                    new SimpleDateFormat("yyyy-MM-dd").parse(doc.getElementsByTagName("forecast date").item(0).getTextContent())
            );

            //read forecast date list
            NodeList nodeListDates = doc.getElementsByTagName("forecast date");

            //create an empty list for forecast dates
            List<Forecast_Date> dates = new ArrayList<>();

            //loop all available date nodes
            for (int i = 0; i < nodeListDates.getLength(); i++) {

                Node node = nodeListDates.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Forecast_Date date = (Forecast_Date) new Forecast_date(
                            elem.getElementsByTagName("night").item(0).getTextContent(),
                            elem.getElementsByTagName("day").item(0).getTextContent()
                    );
                    dates.add(date);
                }
            }
            //set forecast date in forecasts
            forecasts.setForecastDates(dates);

            //read forecast date details first
            forecast_date = (Forecast_date) new Forecast_date(
                    doc.getElementsByTagName("night").item(0).getTextContent(),
                    doc.getElementsByTagName("day").item(0).getTextContent()
            );

            //read night list
            NodeList nodeListNight = doc.getElementsByTagName("night");

            //create an empty list for nights
            List<Night> nights = new ArrayList<>();

            //loop all available night nodes
            for (int i = 0; i < nodeListNight.getLength(); i++) {

                Node node = nodeListNight.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    night = new Night(
                            elem.getElementsByTagName("phenomenon").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("tempmin").item(0).getTextContent()),
                            Integer.parseInt(elem.getElementsByTagName("tempmax").item(0).getTextContent()),
                            elem.getElementsByTagName("text").item(0).getTextContent(),
                            elem.getElementsByTagName("place").item(0).getTextContent()
                    );
                    nights.add(night);
                }
            }

            //set forecast date in forecasts
            forecast_date.setNights(nights);

            //read day list
            NodeList nodeListDay = doc.getElementsByTagName("day");

            //create an empty list for days
            List<Day> days = new ArrayList<>();

            //loop all available day nodes
            for (int i = 0; i < nodeListNight.getLength(); i++) {

                Node node = nodeListNight.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    day = new Day(
                            elem.getElementsByTagName("phenomenon").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("tempmin").item(0).getTextContent()),
                            Integer.parseInt(elem.getElementsByTagName("tempmax").item(0).getTextContent()),
                            elem.getElementsByTagName("text").item(0).getTextContent(),
                            elem.getElementsByTagName("place").item(0).getTextContent()
                    );
                    days.add(day);
                }
            }
            //set forecast date in forecasts
            forecast_date.setDays(days);

            //read night and day details first
            night = new Night(
                    doc.getElementsByTagName("phenomenon").item(0).getTextContent(),
                    Integer.parseInt(doc.getElementsByTagName("tempmin").item(0).getTextContent()),
                    Integer.parseInt(doc.getElementsByTagName("tempmax").item(0).getTextContent()),
                    doc.getElementsByTagName("text").item(0).getTextContent(),
                    doc.getElementsByTagName("place").item(0).getTextContent()
            );

            day = new Day(
                    doc.getElementsByTagName("phenomenon").item(0).getTextContent(),
                    Integer.parseInt(doc.getElementsByTagName("tempmin").item(0).getTextContent()),
                    Integer.parseInt(doc.getElementsByTagName("tempmax").item(0).getTextContent()),
                    doc.getElementsByTagName("text").item(0).getTextContent(),
                    doc.getElementsByTagName("place").item(0).getTextContent()
            );

            //read places list
            NodeList nodeListPlace = doc.getElementsByTagName("place");

            //create an empty list for places
            List<Place> places = new ArrayList<>();

            //loop all available place nodes
            for (int i = 0; i < nodeListPlace.getLength(); i++) {

                Node node = nodeListPlace.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Place place = new Place(
                            Integer.parseInt(elem.getElementsByTagName("tempMin").item(0).getTextContent()),
                            elem.getElementsByTagName("phenomenon").item(0).getTextContent(),
                            elem.getElementsByTagName("name").item(0).getTextContent()
                    );
                    places.add(place);
                }
            }

            //set places in forecast nights
            night.setPlaces(places);

            //set places in forecast days
            day.setPlaces(places);


        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return forecasts;

    }
}

package by.it_academy.homework.homework6;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import by.it_academy.homework.homework6.entity.Customer;
import by.it_academy.homework.homework6.entity.Station;

public class Manager {
    private static Manager instance;
    private final String LINK = "http://kiparo.ru/t/service_station.json";
    private LocalBroadcastManager mLocalBroadcastManager;
    private ArrayList<Customer> findedCustomers = new ArrayList<>();
    private String nameOfFile;
    private Station st;

    public void setNameOfFile(String nameOfFile){
        this.nameOfFile = nameOfFile;
    }

    public ArrayList<Customer> getFinded(){
        return findedCustomers;
    }


    public static synchronized Manager getInstance(LocalBroadcastManager localBroadcastManager) { // Singleton
        if (instance == null) {
            instance = new Manager(localBroadcastManager);
        }
        return instance;
    }

    private Manager(LocalBroadcastManager localBroadcastManager){
        this.mLocalBroadcastManager = localBroadcastManager;
    }
    public void connect() throws ParserConfigurationException,
            IOException, ParseException, SAXException {
        URLConnector url = new URLConnector(nameOfFile); // Задаем имя файла, в который URLConnector будет сохранять данные
        try {
            url.downloadFile(LINK);                      //Скачиваем данные по ссылке
            JSONParser parser = new JSONParser();
            st = parser.parse(nameOfFile);
        } catch (MalformedInputException e) {
            //     ui.print(e.getMessage()); // Все сообщения об ошибках выводятся пользователю через UI
        }
    }

    public void getData(){
    Thread downloadAndParse = new Thread(new Runnable() {
        @Override
        public void run() {
            try{
            connect();
            findedCustomers = st.getCustomers();
                sendNotify();
            }catch (Exception e){
                Log.e("Hw 6", e.getLocalizedMessage());
            }
        }
    });
        downloadAndParse.start();
    }



    public void searchCustomerByName(String name){
        ArrayList<Customer> searched = new ArrayList<>();
        Pattern pattern = Pattern.compile(name.toLowerCase());
        for(Customer customer : st.getCustomers()){
            Matcher matcher = pattern.matcher(customer.getName().toLowerCase());
            if (matcher.find()){
                searched.add(customer);
            }
        }
        findedCustomers = searched;
        sendNotify();
    }

    private void sendNotify(){
        mLocalBroadcastManager.sendBroadcast(new Intent(HomeWork6Activity.PARSINGISDONE));
    }

}






package com.dotplays.storedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.edtData);

    }


    public void createCacheFile(View view) {

        // tao ra file tren bo nho
        try {
            String data = edtData.getText().toString().trim();


            // lay duong dan cua cache file tren he thong
            File fileCacheDir = getCacheDir();

            // dat ten cho file cache
            String cacheFileName = "myfile.cache";

            // tao ra bien file cache de luu du lieu
            File newCacheFile = new File(fileCacheDir, cacheFileName);
            newCacheFile.createNewFile();

            // mo ket noi toi file vua tao
            FileOutputStream stream = new FileOutputStream(newCacheFile.getAbsoluteFile());

            // ghi du lieu duoi dang byte[]
            stream.write(data.getBytes());

            // dong ket noi
            stream.close();

            // clear o nhap.
            edtData.setText("");

            Toast.makeText(this, "Ghi thanh cong!!!", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

    public void loadCacheFile(View view) {


        try {

            // lay duong dan cua cache file tren he thong
            File fileCacheDir = getCacheDir();

            // dat ten cho file cache
            String cacheFileName = "myfile.cache";

            // tao ra bien file cache de luu du lieu
            File newCacheFile = new File(fileCacheDir, cacheFileName);


            Scanner scanner = new Scanner(newCacheFile);

            // khoi tao bien string de luu du lieu doc duoc
            String data = "";

            while (scanner.hasNext()) {
                // doc tung dong va noi vao bien data , \n tuc la xuong dong
                data = data + scanner.nextLine() + "\n";
            }
            // dong ket noi
            scanner.close();

            // hien thi du lieu len edit Text
            edtData.setText(data);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void writeToSDCard(View view) {

        // kiem tra thiet bi co sd card hay ko, co thi moi tien hanh doc ghi
        boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        boolean isSDSupportedDevice = Environment.isExternalStorageRemovable();

        if (isSDSupportedDevice && isSDPresent) {
            // yes SD-card is present

        } else {
            // Sorry
            
        }


    }

    public void loadFromSDCard(View view) {


    }
}

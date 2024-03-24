package com.example.mirea_prac_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<String> selectedUsers = new ArrayList<String>();

        Intent i = getIntent();
        String str = i.getStringExtra("product");
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        String[] products2;

        switch (str) {
            case "Мясо":
                products2 = getResources().getStringArray(R.array.Meal);
                break;
            case "Рыба":
                products2 = getResources().getStringArray(R.array.Fish);
                break;
            case "Овощи":
                products2 = getResources().getStringArray(R.array.Vegetables);
                break;
            case "Крупы":
                products2 = getResources().getStringArray(R.array.Cereals);
                break;
            case "Молоко и молочные продукты":
                products2 = getResources().getStringArray(R.array.Milk);
                break;
            case "Фрукты":
                products2 = getResources().getStringArray(R.array.Fruits);
                break;
            case "Ягоды":
                products2 = getResources().getStringArray(R.array.Berries);
                break;
            default:
                products2 = getResources().getStringArray(R.array.Products);
        }

        ListView products_view = (ListView) findViewById(R.id.my_list_view2);


        ArrayAdapter<String> productsAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_multiple_choice, products2);

        products_view.setAdapter(productsAdapter);

        products_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // получаем нажатый элемент
                String user = productsAdapter.getItem(position);
                if(products_view.isItemChecked(position))
                    selectedUsers.add(user);
                else
                    selectedUsers.remove(user);


            }
        });


        public void add(View v)


        public void remove(View view){
            // получаем и удаляем выделенные элементы
            for(int k =0; k < selectedUsers.size();k++){
                productsAdapter.remove(selectedUsers.get(k));
            }
            // снимаем все ранее установленные отметки
            products_view.clearChoices();
            // очищаем массив выбраных объектов
            selectedUsers.clear();

            productsAdapter.notifyDataSetChanged();
        }


}
package com.android.zycojamie.callphone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int CALL=1;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button number0;
    private Button numberX;
    private Button numberJ;
    private CircleImageView call;
    private Button back;
    private TextView numberText;
    private StringBuilder textString=new StringBuilder(); //用于修改TextView
    private StringBuilder textString2=new StringBuilder();  //用于匹配正则表达式
    private ListView listView;
    private ContactAdapter adapter;
    private List<Contacts> mList=new ArrayList<>();
    private List<String> permissions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number0=(Button)findViewById(R.id.num0);
        number1=(Button)findViewById(R.id.num1);
        number2=(Button)findViewById(R.id.num2);
        number3=(Button)findViewById(R.id.num3);
        number4=(Button)findViewById(R.id.num4);
        number5=(Button)findViewById(R.id.num5);
        number6=(Button)findViewById(R.id.num6);
        number7=(Button)findViewById(R.id.num7);
        number8=(Button)findViewById(R.id.num8);
        number9=(Button)findViewById(R.id.num9);
        numberX=(Button)findViewById(R.id.numX);
        numberJ=(Button)findViewById(R.id.numJ);
        call=(CircleImageView) findViewById(R.id.call);
        back=(Button)findViewById(R.id.back);
        numberText=(TextView)findViewById(R.id.numberText);
        listView=(ListView)findViewById(R.id.list);
        adapter=new ContactAdapter(MainActivity.this,R.layout.listview_item,mList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{
                    Contacts contacts=mList.get(position);
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+contacts.getNumber()));
                    startActivity(intent);
                }catch(SecurityException e){
                    e.printStackTrace();
                }
            }

        });
        numberText.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                mList.clear();
                adapter.notifyDataSetChanged();
                Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
                while(cursor.moveToNext()){
                    String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Contacts contacts=new Contacts(name,number);
                    Pattern pattern=Pattern.compile("("+textString2.toString()+")"+"+");
                    Matcher matcher=pattern.matcher(number);
                    if(matcher.find()){
                        mList.add(contacts);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        numberX.setOnClickListener(this);
        numberJ.setOnClickListener(this);
        call.setOnClickListener(this);
        back.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.CALL_PHONE);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_CONTACTS)!=PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.READ_CONTACTS);
        }
        if(!permissions.isEmpty()){
            String[] permissions2=permissions.toArray(new String[permissions.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions2,CALL);
        }
    }
    public void onClick(View view){
        switch(view.getId()){
            case R.id.num0:
                textString.append("0");
                textString2.append("0");
                numberText.setText(textString.toString());
                break;
            case R.id.num1:
                textString.append("1");
                textString2.append("1");
                numberText.setText(textString.toString());
                break;
            case R.id.num2:
                textString.append("2");
                textString2.append("2");
                numberText.setText(textString.toString());
                break;
            case R.id.num3:
                textString.append("3");
                textString2.append("3");
                numberText.setText(textString.toString());
                break;
            case R.id.num4:
                textString.append("4");
                textString2.append("4");
                numberText.setText(textString.toString());
                break;
            case R.id.num5:
                textString.append("5");
                textString2.append("5");
                numberText.setText(textString.toString());
                break;
            case R.id.num6:
                textString.append("6");
                textString2.append("6");
                numberText.setText(textString.toString());
                break;
            case R.id.num7:
                textString.append("7");
                textString2.append("7");
                numberText.setText(textString.toString());
                break;
            case R.id.num8:
                textString.append("8");
                textString2.append("8");
                numberText.setText(textString.toString());
                break;
            case R.id.num9:
                textString.append("9");
                textString2.append("9");
                numberText.setText(textString.toString());
                break;
            case R.id.numX:
                textString.append("*");
                textString2.append("\\*");
                numberText.setText(textString.toString());
                break;
            case R.id.numJ:
                textString.append("#");
                textString2.append("\\#");
                numberText.setText(textString.toString());
                break;
            case R.id.back:
                if(textString.length()!=0){
                    if((textString.toString().lastIndexOf("*")!=-1 && textString.toString().lastIndexOf("*")==(textString.length()-1)) || (textString.toString().lastIndexOf("#")!=-1 && textString.toString().lastIndexOf("#")==(textString.length()-1))){
                        textString.setLength(textString.length()-1);
                        textString2.setLength(textString2.length()-2);
                        numberText.setText(textString.toString());

                    }else{
                        textString.setLength(textString.length()-1);
                        textString2.setLength(textString2.length()-1);
                        numberText.setText(textString.toString());
                    }
                }
                break;
            case R.id.call:
                try{
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+textString.toString()));
                    startActivity(intent);
                }catch(SecurityException e){
                    e.printStackTrace();
                }
                break;
            default:;

        }
    }
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResult){
        for(int grant:grantResult){
            if(grant!=PackageManager.PERMISSION_GRANTED){
                finish();
            }
        }
    }
}

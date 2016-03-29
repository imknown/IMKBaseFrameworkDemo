package com.soft2t.imk2tbaseframework.demo.module.demo;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoParcelableActivity extends MyBaseActivity {

    public static final String Key = "personList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Person> personList = new ArrayList<Person>() {
            {
                //==================================
                add(new Person());

                //==================================
                Parcel parcel = Parcel.obtain();
                Person person = Person.CREATOR.createFromParcel(parcel);
                person.setName("1");
                add(person);
                parcel.recycle();

                //==================================
                Person p = new Person("2");
                ArrayList<Pet> petList = new ArrayList<Pet>() {
                    {
                        add(new Pet("姜黄猫", "Minecraft"));
                        add(new Pet("黑白熊", "坏人"));
                        add(new Pet("女神", "林志玲"));
                    }
                };
                p.setPetList(petList);
                add(p);
            }

        };

        finish();

        Intent i = new Intent(this, DemoRootActivity.class);
        i.putParcelableArrayListExtra(Key, personList);

        startActivity(i);
    }
}

class Person implements Parcelable {
    private String username = "没给名字";
    private String password;
    private int age;
    private boolean isGay;
    private List<Pet> petList;
    private Map<String, String> stringMap;

    Person() {
    }

    Person(String username) {
        this.username = username;
    }

    void setName(String username) {
        this.username = username;
    }

    String getName() {
        return username;
    }

    void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    List<Pet> getPetList() {
        return petList;
    }

    protected Person(Parcel in) {
        username = in.readString();
        password = in.readString();
        age = in.readInt();
        isGay = in.readByte() != 0;
        petList = in.createTypedArrayList(Pet.CREATOR);
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeInt(age);
        dest.writeByte((byte) (isGay ? 1 : 0));
        dest.writeTypedList(petList);
    }
}

class Pet implements Parcelable {
    private String kind = "未知品种";
    private String name = "宠物没有名字";
    private SQLException exception;

    Pet(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Pet(Parcel in) {
        kind = in.readString();
        name = in.readString();
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kind);
        dest.writeString(name);
    }
}
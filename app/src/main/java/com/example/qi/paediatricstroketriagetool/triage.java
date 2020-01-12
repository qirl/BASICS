package com.example.qi.paediatricstroketriagetool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class triage extends AppCompatActivity {

    private Button triage;
    TextView studyidtext;

    private triageDBHandler db;

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    Button btnsymptomDatePicker, btnsymptomTimePicker;
    EditText txtsymptomDate, txtsymptomTime;
    private int symptomYear, symptomMonth, symptomDay, symptomHour, symptomMinute;

    Button btnbirthday;
    EditText txtbirthday;
    private int birthdayYear, birthdayMonth, birthdayDay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triage);

        btnDatePicker=(Button)findViewById(R.id.arrivaldate);
        btnTimePicker=(Button)findViewById(R.id.arrivaltime);
        txtDate=(EditText)findViewById(R.id.dateofarrival);
        txtTime=(EditText)findViewById(R.id.timeofarrival);

        btnsymptomDatePicker = (Button)findViewById(R.id.symptomdate);
        btnsymptomTimePicker = (Button)findViewById(R.id.symptomtime);
        txtsymptomDate = (EditText)findViewById(R.id.dateofsymptom);
        txtsymptomTime = (EditText)findViewById(R.id.timeofsymptom);

        btnbirthday = (Button)findViewById(R.id.birthday);
        txtbirthday = (EditText)findViewById(R.id.birthdaytext);

        btnbirthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar cbirthday = Calendar.getInstance();
                birthdayYear = cbirthday.get(Calendar.YEAR);
                birthdayMonth = cbirthday.get(Calendar.MONTH);
                birthdayDay = cbirthday.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(triage.this, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtbirthday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, birthdayYear, birthdayMonth, birthdayDay);
                datePickerDialog.show();
            }
        });

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(triage.this, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(triage.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        btnsymptomDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar symptomc = Calendar.getInstance();
                symptomYear = symptomc.get(Calendar.YEAR);
                symptomMonth = symptomc.get(Calendar.MONTH);
                symptomDay = symptomc.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(triage.this, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtsymptomDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, symptomYear, symptomMonth, symptomDay);
                datePickerDialog.show();
            }
        });

        btnsymptomTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar symptomc = Calendar.getInstance();
                symptomHour = symptomc.get(Calendar.HOUR_OF_DAY);
                symptomMinute = symptomc.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(triage.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtsymptomTime.setText(hourOfDay + ":" + minute);
                            }
                        }, symptomHour, symptomMinute, false);
                timePickerDialog.show();
            }
        });

        triage = (Button) findViewById(R.id.button_triage);
        triage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String birthcalendar = txtbirthday.getText().toString();

                String birthyear = birthcalendar.substring(birthcalendar.length() -4, birthcalendar.length());
                int birthyearint = Integer.parseInt(birthyear);
                String birthmonth = birthcalendar.substring(birthcalendar.indexOf("-") + 1, birthcalendar.length()-5);
                int birthmonthint = Integer.parseInt(birthmonth);
                String brithday = birthcalendar.substring(0, birthcalendar.indexOf("-"));
                int birthdayint = Integer.parseInt(brithday);

                String symptomcalendar = txtsymptomDate.getText().toString();

                String symptomyear = symptomcalendar.substring(symptomcalendar.length() -4, symptomcalendar.length());
                int symptomyearint = Integer.parseInt(symptomyear);
                String symptomonth = symptomcalendar.substring(symptomcalendar.indexOf("-") + 1, symptomcalendar.length()-5);
                int symptommonthint = Integer.parseInt(symptomonth);
                String symptomday = symptomcalendar.substring(0, symptomcalendar.indexOf("-"));
                int symptomdayint = Integer.parseInt(symptomday);

                String arrivalcalendar = txtDate.getText().toString();

                String arrivalyear = arrivalcalendar.substring(arrivalcalendar.length() -4, arrivalcalendar.length());
                int arrivalyearint = Integer.parseInt(arrivalyear);
                String arrivalmonth = arrivalcalendar.substring(arrivalcalendar.indexOf("-") + 1, arrivalcalendar.length()-5);
                int arrivalmonthint = Integer.parseInt(arrivalmonth);
                String arrivalday = arrivalcalendar.substring(0, arrivalcalendar.indexOf("-"));
                int arrivaldayint = Integer.parseInt(arrivalday);

                String symptomtimestring = txtsymptomTime.getText().toString();
                String symptomhourstring = symptomtimestring.substring(0,symptomtimestring.indexOf(":"));
                int symptomhourint = Integer.parseInt(symptomhourstring);
                String symptomminstring = symptomtimestring.substring(symptomtimestring.indexOf(":") +1);
                int symptomminint = Integer.parseInt(symptomminstring);

                String arrivaltimestring = txtTime.getText().toString();

                String arrivalhourstring = arrivaltimestring.substring(0,arrivaltimestring.indexOf(":"));
                int arrivalhourint = Integer.parseInt(arrivalhourstring);
                String arrivalminstring = arrivaltimestring.substring(arrivaltimestring.indexOf(":") +1);
                int arrivalminint = Integer.parseInt(arrivalminstring);

                double patientage;
                if(arrivalmonthint >= birthmonthint){
                    patientage = (arrivalyearint - birthyearint)+ (arrivalmonthint - birthmonthint)/12;
                }else{
                    patientage = (arrivalyearint - birthyearint) - (birthmonthint - arrivalmonthint)/12;
                }

                studyidtext = (TextView)findViewById(R.id.studyID);
                String studyidstring = studyidtext.getText().toString();
                int studyid = Integer.parseInt(studyidstring);

                RadioGroup tgenderchoose = (RadioGroup) findViewById(R.id.tgendergroup);
                int tcheckRadioButtonId_gender = tgenderchoose.getCheckedRadioButtonId();
                int tgendershared = 0;
                switch (tcheckRadioButtonId_gender) {
                    case R.id.tgender_y:
                        tgendershared = 0;
                        break;
                    case R.id.tgender_n:
                        tgendershared = 1;
                        break;
                }

                RadioGroup tpmhxchoose = (RadioGroup) findViewById(R.id.tpmhxgroup);
                int tcheckRadioButtonId_pmhx = tpmhxchoose.getCheckedRadioButtonId();
                int tpmhxshared = 0;
                switch (tcheckRadioButtonId_pmhx) {
                    case R.id.tpmhx_y:
                        tpmhxshared = 1;
                        break;
                    case R.id.tpmhx_n:
                        tpmhxshared = 0;
                        break;
                }

                RadioGroup tsuddenchoose = (RadioGroup) findViewById(R.id.tsuddengroup);
                int tcheckRadioButtonId_sudden = tsuddenchoose.getCheckedRadioButtonId();
                int tsuddenshared = 0;
                switch (tcheckRadioButtonId_sudden) {
                    case R.id.tsudden_y:
                        tsuddenshared = 1;
                        break;
                    case R.id.tsudden_n:
                        tsuddenshared = 0;
                        break;
                }

                RadioGroup twokechoose = (RadioGroup) findViewById(R.id.twokegroup);
                int tcheckRadioButtonId_woke = twokechoose.getCheckedRadioButtonId();
                int twokeshared = 0;
                switch (tcheckRadioButtonId_woke) {
                    case R.id.twoke_y:
                        twokeshared = 1;
                        break;
                    case R.id.twoke_n:
                        twokeshared = 0;
                        break;
                }

                RadioGroup twellweekb4choose = (RadioGroup) findViewById(R.id.twellweekb4group);
                int tcheckRadioButtonId_wellweekb4 = twellweekb4choose.getCheckedRadioButtonId();
                int twellweekb4shared = 0;
                switch (tcheckRadioButtonId_wellweekb4) {
                    case R.id.twellweekb4_y:
                        twellweekb4shared = 1;
                        break;
                    case R.id.twellweekb4_n:
                        twellweekb4shared = 0;
                        break;
                }

                RadioGroup tmedicaltransportchoose = (RadioGroup) findViewById(R.id.tmedicaltransportgroup);
                int tcheckRadioButtonId_medicaltransport = tmedicaltransportchoose.getCheckedRadioButtonId();
                int tmedicaltransportshared = 0;
                switch (tcheckRadioButtonId_medicaltransport) {
                    case R.id.tmedicaltransport_y:
                        tmedicaltransportshared = 1;
                        break;
                    case R.id.tmedicaltransport_n:
                        tmedicaltransportshared = 0;
                        break;
                }

                RadioGroup tvertigo_group = (RadioGroup) findViewById(R.id.tvertigogroup);
                int tcheckRadioButtonId_vertigo = tvertigo_group.getCheckedRadioButtonId();
                int tvertigovalue = 0;
                switch (tcheckRadioButtonId_vertigo) {
                    case R.id.tvertigo_y:
                        tvertigovalue = 1;
                        break;
                    case R.id.tvertigo_n:
                        tvertigovalue = 0;
                        break;
                }

                RadioGroup theadache_group = (RadioGroup) findViewById(R.id.theadachegroup);
                int tcheckRadioButtonId_theadache = theadache_group.getCheckedRadioButtonId();
                int theadacevalue = 0;
                switch (tcheckRadioButtonId_theadache) {
                    case R.id.theadache_y:
                        theadacevalue = 1;
                        break;
                    case R.id.theadache_n:
                        theadacevalue = 0;
                        break;
                }

                RadioGroup tvomit_group = (RadioGroup) findViewById(R.id.tvomitgroup);
                int tcheckRadioButtonId_vomit = tvomit_group.getCheckedRadioButtonId();
                int tvomitvalue = 0;
                switch (tcheckRadioButtonId_vomit) {
                    case R.id.tvomit_y:
                        tvomitvalue = 1;
                        break;
                    case R.id.tvomit_n:
                        tvomitvalue = 0;
                        break;
                }

                RadioGroup tdizziness_group = (RadioGroup) findViewById(R.id.tdizzinessgroup);
                int tcheckRadioButtonId_dizziness = tdizziness_group.getCheckedRadioButtonId();
                int tdizzinessvalue = 0;
                switch (tcheckRadioButtonId_dizziness) {
                    case R.id.tdizziness_y:
                        tdizzinessvalue = 1;
                        break;
                    case R.id.tdizziness_n:
                        tdizzinessvalue = 0;
                        break;
                }

                RadioGroup tspeechloss_group = (RadioGroup) findViewById(R.id.tspeechlossgroup);
                int tcheckRadioButtonId_speechloss = tspeechloss_group.getCheckedRadioButtonId();
                int tspeechlossvalue = 0;
                switch (tcheckRadioButtonId_speechloss) {
                    case R.id.tspeechloss_y:
                        tspeechlossvalue = 1;
                        break;
                    case R.id.tspeechloss_n:
                        tspeechlossvalue = 0;
                        break;
                }

                RadioGroup tfocalnumb_group = (RadioGroup) findViewById(R.id.tfocalnumbgroup);
                int tcheckRadioButtonId_focalnumb = tfocalnumb_group.getCheckedRadioButtonId();
                int tfocalnumbvalue = 0;
                switch (tcheckRadioButtonId_focalnumb) {
                    case R.id.tfocalnumb_y:
                        tfocalnumbvalue = 1;
                        break;
                    case R.id.tfocalnumb_n:
                        tfocalnumbvalue = 0;
                        break;
                }

                RadioGroup tfocalweak_group = (RadioGroup) findViewById(R.id.tfocalweakgroup);
                int tcheckRadioButtonId_focalweek = tfocalweak_group.getCheckedRadioButtonId();
                int tfocalweekvalue = 0;
                switch (tcheckRadioButtonId_focalweek) {
                    case R.id.tfocalweak_y:
                        tfocalweekvalue = 1;
                        break;
                    case R.id.tfocalnumb_n:
                        tfocalweekvalue = 0;
                        break;
                }

                RadioGroup tseizure_group = (RadioGroup) findViewById(R.id.tseizuregroup);
                int tcheckRadioButtonId_seizure = tseizure_group.getCheckedRadioButtonId();
                int tseizurevalue = 0;
                switch (tcheckRadioButtonId_seizure) {
                    case R.id.tseizure_y:
                        tseizurevalue = 1;
                        break;
                    case R.id.tseizure_n:
                        tseizurevalue = 0;
                        break;
                }

                RadioGroup tmentalstate_group = (RadioGroup) findViewById(R.id.tmentalstategroup);
                int tcheckRadioButtonId_mentalstate = tmentalstate_group.getCheckedRadioButtonId();
                int tmentalvalue = 0;
                switch (tcheckRadioButtonId_mentalstate) {
                    case R.id.tmentalstate_y:
                        tmentalvalue = 1;
                        break;
                    case R.id.tmentalstate_n:
                        tmentalvalue = 0;
                        break;
                }

                RadioGroup tloc_group = (RadioGroup) findViewById(R.id.tlocgroup);
                int tcheckRadioButtonId_loc = tloc_group.getCheckedRadioButtonId();
                int tlocvalue = 0;
                switch (tcheckRadioButtonId_loc) {
                    case R.id.tloc_y:
                        tlocvalue = 1;
                        break;
                    case R.id.tloc_n:
                        tlocvalue = 0;
                        break;
                }

                RadioGroup tvision_group = (RadioGroup) findViewById(R.id.tvisiongroup);
                int tcheckRadioButtonId_vision = tvision_group.getCheckedRadioButtonId();
                int tvisionvalue = 0;
                switch (tcheckRadioButtonId_vision) {
                    case R.id.tvision_y:
                        tvisionvalue = 1;
                        break;
                    case R.id.tvision_n:
                        tvisionvalue = 0;
                        break;
                }

                RadioGroup tataxia_group = (RadioGroup) findViewById(R.id.tataxiagroup);
                int tcheckRadioButtonId_ataxia = tataxia_group.getCheckedRadioButtonId();
                int tataxiavalue = 0;
                switch (tcheckRadioButtonId_ataxia) {
                    case R.id.tataxia_y:
                        tataxiavalue = 1;
                        break;
                    case R.id.tataxia_n:
                        tataxiavalue = 0;
                        break;
                }

                RadioGroup tother_group = (RadioGroup) findViewById(R.id.tothergroup);
                int tcheckRadioButtonId_other = tother_group.getCheckedRadioButtonId();
                int tothervalue = 0;
                switch (tcheckRadioButtonId_other) {
                    case R.id.tother_y:
                        tothervalue = 1;
                        break;
                    case R.id.tother_n:
                        tothervalue = 0;
                        break;
                }

                RadioGroup treferred_group = (RadioGroup)findViewById(R.id.treferredgroup);
                int tcheckRadioButtonID_referred = treferred_group.getCheckedRadioButtonId();
                int treferredvalue   = 0;
                switch (tcheckRadioButtonID_referred){
                    case R.id.treferred_y:
                        treferredvalue = 1;
                        break;
                    case R.id.treferred_n:
                        treferredvalue = 0;
                        break;
                }

                RadioGroup timproving_group = (RadioGroup)findViewById(R.id.timprovinggroup);
                int tcheckRadiboButton_improving = timproving_group.getCheckedRadioButtonId();
                int timprovingvalue = 0;
                switch (tcheckRadiboButton_improving){
                    case R.id.timproving_y:
                        timprovingvalue = 1;
                        break;
                    case R.id.timproving_n:
                        timprovingvalue = 0;
                        break;
                }

                RadioGroup thighcategory_group = (RadioGroup)findViewById(R.id.thighcategory_group);
                int tcheckRadioButton_highcategory = thighcategory_group.getCheckedRadioButtonId();
                int thighcategoryvalue = 0;
                switch (tcheckRadioButton_highcategory){
                    case R.id.thighcategory_y:
                        thighcategoryvalue = 1;
                        break;
                    case R.id.thighcategory_n:
                        thighcategoryvalue = 0;
                        break;
                }

                RadioGroup tphonophobia_group = (RadioGroup)findViewById(R.id.tphonophobiagroup);
                int tcheckRadioButton_phonophobia = tphonophobia_group.getCheckedRadioButtonId();
                int tphonophobiavalue = 0;
                switch (tcheckRadioButton_phonophobia){
                    case R.id.tphonophobia_yes:
                        tphonophobiavalue = 1;
                        break;
                    case R.id.tphonophobia_no:
                        tphonophobiavalue = 0;
                        break;
                }

                RadioGroup tphotophobia_group = (RadioGroup)findViewById(R.id.tphotophobiagroup);
                int tcheckRadioButton_photophobia = tphotophobia_group.getCheckedRadioButtonId();
                int tphotophobiavalue = 0;
                switch (tcheckRadioButton_photophobia){
                    case R.id.tphotophobia_yes:
                        tphotophobiavalue = 1;
                        break;
                    case R.id.tphotophobia_no:
                        tphotophobiavalue = 0;
                        break;
                }

                double prob_mimics = 0;
                double prob_ischaemic = 0;
                double prob_haemorrhagic = 0;

                if (tothervalue == 0) {
                    if (tmedicaltransportshared == 1) {
                        if (tseizurevalue == 0) {
                            if (tdizzinessvalue == 0) {
                                if (tpmhxshared == 0) {
                                    prob_mimics = 0.06;
                                } else {
                                    prob_mimics = 0.58;
                                }
                            } else {
                                if (tmentalvalue == 1) {
                                    prob_mimics = 0.17;
                                } else {
                                    prob_mimics = 0.83;
                                }
                            }
                        } else {
                            if (patientage >= 7) {
                                if (tdizzinessvalue == 0) {
                                    prob_mimics = 0.2;
                                } else {
                                    prob_mimics = 0.88;
                                }
                            } else {
                                prob_mimics = 0.93;
                            }
                        }
                    } else {
                        if (patientage < 5) {
                            if (theadacevalue == 1) {
                                prob_mimics = 0.14;
                            } else {
                                if (patientage < 0.71) {
                                    prob_mimics = 0.2;
                                } else {
                                    prob_mimics = 0.74;
                                }
                            }
                        } else {
                            prob_mimics = 0.84;
                        }
                    }
                } else {
                    prob_mimics = 0.98;
                }

                //CART model used to calculate probability of ischaemic stroke;
                if (tfocalweekvalue == 0) {
                    if (patientage >= 11) {
                        prob_ischaemic = 0;
                    } else {
                        if (tothervalue == 1) {
                            prob_ischaemic = 0;
                        } else {
                            if (tpmhxshared == 0) {
                                prob_ischaemic = 0.13;
                            } else {
                                if (patientage >= 3.9) {
                                    prob_ischaemic = 0.25;
                                } else {
                                    prob_ischaemic = 0.67;
                                }
                            }
                        }
                    }
                } else {
                    if (tothervalue == 1) {
                        prob_ischaemic = 0;
                    } else {
                        if (tspeechlossvalue == 0) {
                            if (tsuddenshared == 0) {
                                prob_ischaemic = 0;
                            } else {
                                if (patientage >= 5.3) {
                                    prob_ischaemic = 0.2;
                                } else {
                                    prob_ischaemic = 0.52;
                                }
                            }
                        } else {
                            if (tvomitvalue == 1) {
                                prob_ischaemic = 0.27;
                            } else {
                                prob_ischaemic = 0.72;
                            }
                        }
                    }
                }

                //CART model used to calculate probability of haemorrhagic stroke;
                if (tmedicaltransportshared == 0) {
                    prob_haemorrhagic = 0.03;
                } else {
                    if (patientage < 5.8) {
                        prob_haemorrhagic = 0;
                    } else {
                        if (tlocvalue == 0) {
                            prob_haemorrhagic = 0.24;
                        } else {
                            if (tdizzinessvalue == 1) {
                                prob_haemorrhagic = 0;
                            } else {
                                prob_haemorrhagic = 0.86;
                            }
                        }
                    }
                }

                triageDBHandler db = new triageDBHandler(triage.this);

                db.getWritableDatabase();
                Triagepatient triagepatient = new Triagepatient(studyid, birthyearint, birthmonthint, birthdayint, symptomyearint, symptommonthint,
                        symptomdayint,arrivalyearint,arrivalmonthint,arrivaldayint,symptomhourint,symptomminint,arrivalhourint,arrivalminint,
                        patientage,tgendershared,tpmhxshared,twokeshared,twellweekb4shared, tmedicaltransportshared, thighcategoryvalue,
                        tvertigovalue,theadacevalue,
                        tvomitvalue,tdizzinessvalue,tspeechlossvalue,tfocalnumbvalue,tfocalweekvalue, tseizurevalue,tmentalvalue,tlocvalue,
                        tvisionvalue,tataxiavalue,tothervalue,tsuddenshared,timprovingvalue,treferredvalue,tphonophobiavalue,tphotophobiavalue);
                db.addHandler(triagepatient);
                db.close();

                Intent intent = new Intent();
                intent.putExtra("strokemimics", prob_mimics);
                intent.putExtra("ischaemic", prob_ischaemic);
                intent.putExtra("haemorrhagic", prob_haemorrhagic);
                intent.setClass(triage.this, calculatortriage.class);
                startActivity(intent);
            }
        });
    }
}
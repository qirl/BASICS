package com.example.qi.paediatricstroketriagetool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class stroke extends AppCompatActivity {

    private Button strokebutton;
    private Button insertdata;

    TextView studyidtext1;

    int NIHSSscore;
    int GCSscore;
    int lowgcs;
    int group_abngcs;
    int noneuro;

    private triageDBHandler db;

    EditText triagepatientid;
    private TextView stroke_age;

    int stroke_gender;
    int stroke_pmhx;
    int stroke_woke;
    int stroke_wellweekb4;
    int stroke_medicaltransport;
    int stroke_vertigo;
    int stroke_headace;
    int stroke_vomit;
    int stroke_dizziness;
    int stroke_speechloss;
    int stroke_focalnumb;
    int stroke_focalweek;
    int stroke_seizure;
    int stroke_mentalstate;
    int stroke_loc;
    int stroke_vision;
    int stroke_ataxia;
    int stroke_other;
    int stroke_sudden;
    int stroke_improving;
    int stroke_referred;
    int stroke_phonophobia;
    int stroke_photophobia;

    RadioButton stroke_gendery;
    RadioButton stroke_gendern;

    RadioButton stroke_pmhxy;
    RadioButton stroke_pmhxn;

    RadioButton stroke_wokey;
    RadioButton stroke_wokex;

    RadioButton stroke_wellweekb4y;
    RadioButton stroke_wellweekb4n;

    RadioButton stroke_medicaltransporty;
    RadioButton stroke_medicaltransportn;

    RadioButton stroke_vertigoy;
    RadioButton stroke_vertigon;

    RadioButton stroke_headacey;
    RadioButton stroke_headacen;

    RadioButton stroke_vomity;
    RadioButton stroke_vomitn;

    RadioButton stroke_dizzinessy;
    RadioButton stroke_dizzinessn;

    RadioButton stroke_speechlossy;
    RadioButton stroke_speechlossn;

    RadioButton stroke_focalnumby;
    RadioButton stroke_focalnumbn;

    RadioButton stroke_focalweeky;
    RadioButton stroke_focalweekn;

    RadioButton stroke_seizurey;
    RadioButton stroke_seizuren;

    RadioButton stroke_mentalstatey;
    RadioButton stroke_mentalstaten;

    RadioButton stroke_locy;
    RadioButton stroke_locn;

    RadioButton stroke_visiony;
    RadioButton stroke_visionn;

    RadioButton stroke_ataxiay;
    RadioButton stroke_ataxian;

    RadioButton stroke_othery;
    RadioButton stroke_othern;

    RadioButton stroke_suddeny;
    RadioButton stroke_suddenn;

    RadioButton stroke_improvingy;
    RadioButton stroke_improvingn;

    RadioButton stroke_referredy;
    RadioButton stroke_referredn;

    RadioButton stroke_phonophobiay;
    RadioButton stroke_phonophobian;

    RadioButton stroke_photophobiay;
    RadioButton stroke_photophobian;

    int stroke_birthyear;
    int stroke_birthmonth;
    int stroke_birthday;
    int stroke_symptomyear;
    int stroke_symptommonth;
    int stroke_symptomday;
    int stroke_arrivalyear;
    int stroke_arrivalmonth;
    int stroke_arrivalday;
    int stroke_symptomhour;
    int stroke_symptommin;
    int stroke_arrivalhour;
    int stroke_arrivalmin;

    EditText txtDate, txtTime;
    EditText txtsymptomDate, txtsymptomTime;
    EditText txtbirthday;

    EditText txtsysmptomtime;
    EditText txtarrivaltime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke);

        triagepatientid = (EditText)findViewById(R.id.ssstudyID);
        stroke_age = (TextView) findViewById(R.id.sage);

        txtDate=(EditText)findViewById(R.id.sdateofarrival);
        txtTime=(EditText)findViewById(R.id.timeofarrival);

        txtsymptomDate = (EditText)findViewById(R.id.sdateofsymptomonset);
        txtsymptomTime = (EditText)findViewById(R.id.timeofsymptom);

        txtsysmptomtime = (EditText)findViewById(R.id.stimeofsymptomsonset);
        txtarrivaltime = (EditText)findViewById(R.id.stimeofarrivaldate);

        txtbirthday = (EditText)findViewById(R.id.sage);

        /* define RadioButton for importing data from triage database to stroke database*/

        insertdata = (Button)findViewById(R.id.simportdata);
        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triageDBHandler db = new triageDBHandler(stroke.this);
                Triagepatient triagepatient = db.findHandler(triagepatientid.getText().toString());

                if (triagepatient != null) {

                    stroke_birthyear = Integer.valueOf(triagepatient.getBirthyear());
                    stroke_birthmonth = Integer.valueOf(triagepatient.getBirthmonth());
                    stroke_birthday = Integer.valueOf(triagepatient.getBirthday());

                    stroke_symptomyear = Integer.valueOf(triagepatient.getSymptomyear());
                    stroke_symptommonth = Integer.valueOf(triagepatient.getSymptommonth());
                    stroke_symptomday = Integer.valueOf(triagepatient.getSymptomday());

                    stroke_arrivalyear = Integer.valueOf(triagepatient.getArrivalyear());
                    stroke_arrivalmonth = Integer.valueOf(triagepatient.getArrivalmonth());
                    stroke_arrivalday   = Integer.valueOf(triagepatient.getArrivalday());

                    txtbirthday.setText(stroke_birthday + "-" + stroke_birthmonth + "-" + stroke_birthyear);
                    txtDate.setText(stroke_arrivalday + "-" + stroke_arrivalmonth + "-" + stroke_arrivalyear);
                    txtsymptomDate.setText(stroke_symptomday + "-" + stroke_symptommonth + "-" + stroke_symptomyear);


                    stroke_symptomhour = Integer.valueOf(triagepatient.getSymptomhour());
                    stroke_symptommin = Integer.valueOf(triagepatient.getSymptommin());
                    stroke_arrivalhour = Integer.valueOf(triagepatient.getArrivalhour());
                    stroke_arrivalmin = Integer.valueOf(triagepatient.getArrivalmin());

                    txtsysmptomtime.setText(stroke_symptomhour + ":" + stroke_symptommin);
                    txtarrivaltime.setText(stroke_arrivalhour + ":" + stroke_arrivalmin);


                    stroke_gender = Integer.valueOf(triagepatient.getGender());
                    stroke_gendery = (RadioButton)findViewById(R.id.sgender_y);
                    stroke_gendern = (RadioButton)findViewById(R.id.sgender_n);
                    if(stroke_gender == 1){
                        stroke_gendery.setChecked(true);
                    }else{
                        stroke_gendern.setChecked(true);
                    }

                    stroke_pmhx = Integer.valueOf(triagepatient.getPmhx());
                    stroke_pmhxy = (RadioButton)findViewById(R.id.spmhx_y);
                    stroke_pmhxn = (RadioButton)findViewById(R.id.spmhx_n);
                    if(stroke_pmhx == 1){
                        stroke_pmhxy.setChecked(true);
                    }else{
                        stroke_pmhxn.setChecked(true);
                    }

                    stroke_woke = Integer.valueOf(triagepatient.getWoke());
                    stroke_wokey = (RadioButton)findViewById(R.id.swoke_y);
                    stroke_wokex = (RadioButton)findViewById(R.id.swoke_n);
                    if(stroke_woke == 1){
                        stroke_wokey.setChecked(true);
                    }else{
                        stroke_wokex.setChecked(true);
                    }

                    stroke_wellweekb4 = Integer.valueOf(triagepatient.getWellweekb4());
                    stroke_wellweekb4y = (RadioButton)findViewById(R.id.swellweekb4_y);
                    stroke_wellweekb4n = (RadioButton)findViewById(R.id.swellweekb4_n);
                    if(stroke_wellweekb4 == 1){
                        stroke_wellweekb4y.setChecked(true);
                    }else{
                        stroke_wellweekb4n.setChecked(true);
                    }

                    stroke_medicaltransport = Integer.valueOf(triagepatient.getMedicaltransport());
                    stroke_medicaltransporty = (RadioButton)findViewById(R.id.smedicaltransport_y);
                    stroke_medicaltransportn = (RadioButton)findViewById(R.id.smedicaltransport_n);
                    if(stroke_medicaltransport == 1){
                        stroke_medicaltransporty.setChecked(true);
                    }else{
                        stroke_medicaltransportn.setChecked(true);
                    }

                    stroke_vertigo = Integer.valueOf(triagepatient.getVertigo());
                    stroke_vertigoy = (RadioButton)findViewById(R.id.svertigo_y);
                    stroke_vertigon = (RadioButton)findViewById(R.id.svertigo_n);
                    if(stroke_vertigo == 1){
                        stroke_vertigoy.setChecked(true);
                    }else{
                        stroke_vertigon.setChecked(true);
                    }

                    stroke_headace = Integer.valueOf(triagepatient.getHeadace());
                    stroke_headacey = (RadioButton)findViewById(R.id.sheadache_y);
                    stroke_headacen = (RadioButton)findViewById(R.id.sheadache_n);
                    if(stroke_headace == 1){
                        stroke_headacey.setChecked(true);
                    }else{
                        stroke_headacen.setChecked(true);
                    }

                    stroke_vomit = Integer.valueOf(triagepatient.getVomit());
                    stroke_vomity = (RadioButton)findViewById(R.id.svomit_y);
                    stroke_vomitn = (RadioButton)findViewById(R.id.svomit_n);
                    if(stroke_vomit == 1){
                        stroke_vomity.setChecked(true);
                    }else{
                        stroke_vomitn.setChecked(true);
                    }

                    stroke_dizziness = Integer.valueOf(triagepatient.getDizziness());
                    stroke_dizzinessy = (RadioButton)findViewById(R.id.sdizziness_y);
                    stroke_dizzinessn = (RadioButton)findViewById(R.id.sdizziness_n);
                    if(stroke_dizziness == 1){
                        stroke_dizzinessy.setChecked(true);
                    }else{
                        stroke_dizzinessn.setChecked(true);
                    }

                    stroke_speechloss = Integer.valueOf(triagepatient.getSpeechloss());
                    stroke_speechlossy = (RadioButton)findViewById(R.id.sspeechloss_y);
                    stroke_speechlossn = (RadioButton)findViewById(R.id.sspeechloss_n);
                    if(stroke_speechloss == 1){
                        stroke_speechlossy.setChecked(true);
                    }else{
                        stroke_speechlossn.setChecked(true);
                    }

                    stroke_focalnumb = Integer.valueOf(triagepatient.getFocalnumb());
                    stroke_focalnumby = (RadioButton)findViewById(R.id.sfocalnumb_y);
                    stroke_focalnumbn = (RadioButton)findViewById(R.id.sfocalnumb_n);
                    if(stroke_focalnumb == 1){
                        stroke_focalnumby.setChecked(true);
                    }else{
                        stroke_focalnumbn.setChecked(true);
                    }

                    stroke_focalweek = Integer.valueOf(triagepatient.getFocalweek());
                    stroke_focalweeky = (RadioButton)findViewById(R.id.sfocalweak_y);
                    stroke_focalweekn = (RadioButton)findViewById(R.id.sfocalweak_n);
                    if(stroke_focalweek == 1){
                        stroke_focalweeky.setChecked(true);
                    }else{
                        stroke_focalweekn.setChecked(true);
                    }

                    stroke_seizure = Integer.valueOf(triagepatient.getSeizure());
                    stroke_seizurey = (RadioButton)findViewById(R.id.sseizure_y);
                    stroke_seizuren = (RadioButton)findViewById(R.id.sseizure_n);
                    if(stroke_seizure == 1){
                        stroke_seizurey.setChecked(true);
                    }else{
                        stroke_seizuren.setChecked(true);
                    }

                    stroke_mentalstate = Integer.valueOf(triagepatient.getMentalstate());
                    stroke_mentalstatey = (RadioButton)findViewById(R.id.smentalstate_y);
                    stroke_mentalstaten = (RadioButton)findViewById(R.id.smentalstate_n);
                    if(stroke_mentalstate == 1){
                        stroke_mentalstatey.setChecked(true);
                    }else{
                        stroke_mentalstaten.setChecked(true);
                    }

                    stroke_loc = Integer.valueOf(triagepatient.getLoc());
                    stroke_locy = (RadioButton)findViewById(R.id.sloc_y);
                    stroke_locn = (RadioButton)findViewById(R.id.sloc_n);
                    if(stroke_loc == 1){
                        stroke_locy.setChecked(true);
                    }else{
                        stroke_locn.setChecked(true);
                    }

                    stroke_vision = Integer.valueOf(triagepatient.getVision());
                    stroke_visiony = (RadioButton)findViewById(R.id.svision_y);
                    stroke_visionn = (RadioButton)findViewById(R.id.svision_n);
                    if(stroke_vision == 1){
                        stroke_visiony.setChecked(true);
                    }else{
                        stroke_visionn.setChecked(true);
                    }

                    stroke_ataxia = Integer.valueOf(triagepatient.getAtaxia());
                    stroke_ataxiay = (RadioButton)findViewById(R.id.sataxia_y);
                    stroke_ataxian = (RadioButton)findViewById(R.id.sataxia_n);
                    if(stroke_ataxia == 1){
                        stroke_ataxiay.setChecked(true);
                    }else{
                        stroke_ataxian.setChecked(true);
                    }

                    stroke_other = Integer.valueOf(triagepatient.getOther());
                    stroke_othery = (RadioButton)findViewById(R.id.sother_y);
                    stroke_othern = (RadioButton)findViewById(R.id.sother_n);
                    if(stroke_other == 1){
                        stroke_othery.setChecked(true);
                    }else{
                        stroke_othern.setChecked(true);
                    }

                    stroke_sudden = Integer.valueOf(triagepatient.getSudden());
                    stroke_suddeny = (RadioButton)findViewById(R.id.ssudden_y);
                    stroke_suddenn = (RadioButton)findViewById(R.id.ssudden_n);
                    if(stroke_sudden == 1){
                        stroke_suddeny.setChecked(true);
                    }else{
                        stroke_suddenn.setChecked(true);
                    }

                    stroke_improving = Integer.valueOf(triagepatient.getImproving());
                    stroke_improvingy = (RadioButton)findViewById(R.id.simprove_y);
                    stroke_improvingn = (RadioButton)findViewById(R.id.simprove_n);
                    if(stroke_improving == 1){
                        stroke_improvingy.setChecked(true);
                    }else{
                        stroke_improvingn.setChecked(true);
                    }

                    stroke_referred = Integer.valueOf(triagepatient.getReferred());
                    stroke_referredy = (RadioButton)findViewById(R.id.sreferred_y);
                    stroke_referredn = (RadioButton)findViewById(R.id.sreferred_n);
                    if(stroke_referred == 1){
                        stroke_referredy.setChecked(true);
                    }else{
                        stroke_referredn.setChecked(true);
                    }

                    stroke_phonophobia = Integer.valueOf(triagepatient.getPhonophobia());
                    stroke_phonophobiay = (RadioButton)findViewById(R.id.sphonophobia_yes);
                    stroke_phonophobian = (RadioButton)findViewById(R.id.sphonophobia_no);
                    if(stroke_phonophobia == 1){
                        stroke_phonophobiay.setChecked(true);
                    }else{
                        stroke_phonophobian.setChecked(true);
                    }

                    stroke_photophobia = Integer.valueOf(triagepatient.getPhonophobia());
                    stroke_photophobiay = (RadioButton)findViewById(R.id.sphotophobia_yes);
                    stroke_photophobian = (RadioButton)findViewById(R.id.sphotophobia_no);
                    if(stroke_photophobia == 1){
                        stroke_photophobiay.setChecked(true);
                    }else{
                        stroke_photophobian.setChecked(true);
                    }
                    }
                else{
                    stroke_age.setText("NO");
                }
                }
        });

        strokebutton = (Button) findViewById(R.id.sbutton_stroke);
        strokebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String birthcalendar = txtbirthday.getText().toString();

                String birthyear = birthcalendar.substring(birthcalendar.length() -4, birthcalendar.length());
                int birthyearint = Integer.parseInt(birthyear);
                String birthmonth = birthcalendar.substring(birthcalendar.indexOf("-") + 1, birthcalendar.length()-5);
                int birthmonthint = Integer.parseInt(birthmonth);
                String brithday = birthcalendar.substring(0, birthcalendar.indexOf("-"));
                int birthdayint = Integer.parseInt(brithday);


                String symptomcalendar = txtsymptomDate.getText().toString();

                String symptomyear = birthcalendar.substring(birthcalendar.length() -4, birthcalendar.length());
                int symptomyearint = Integer.parseInt(symptomyear);
                String symptomonth = birthcalendar.substring(birthcalendar.indexOf("-") + 1, birthcalendar.length()-5);
                int symptommonthint = Integer.parseInt(symptomonth);
                String symptomday = birthcalendar.substring(0, birthcalendar.indexOf("-"));
                int symptomdayint = Integer.parseInt(symptomday);

                String arrivalcalendar = txtDate.getText().toString();

                String arrivalyear = birthcalendar.substring(birthcalendar.length() -4, birthcalendar.length());
                int arrivalyearint = Integer.parseInt(symptomyear);
                String arrivalmonth = birthcalendar.substring(birthcalendar.indexOf("-") + 1, birthcalendar.length()-5);
                int arrivalmonthint = Integer.parseInt(symptomonth);
                String arrivalday = birthcalendar.substring(0, birthcalendar.indexOf("-"));
                int arrivaldayint = Integer.parseInt(symptomday);

                String symptomtimestring = txtsysmptomtime.getText().toString();

                String symptomhourstring = symptomtimestring.substring(0,symptomtimestring.indexOf(":"));
                int symptomhourint = Integer.parseInt(symptomhourstring);
                String symptomminstring = symptomtimestring.substring(symptomtimestring.indexOf(":") +1);
                int symptomminint = Integer.parseInt(symptomminstring);

                String arrivaltimestring = txtarrivaltime.getText().toString();

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

                studyidtext1 = findViewById(R.id.ssstudyID);
                String studyidstring = studyidtext1.getText().toString();
                int studyid = Integer.parseInt(studyidstring);


                RadioGroup sgender = (RadioGroup) findViewById(R.id.sgendergroup);
                int scheckRadioButtonId_gender = sgender.getCheckedRadioButtonId();
                int sgendervalue = 0;
                switch (scheckRadioButtonId_gender) {
                    case R.id.sgender_y:
                        sgendervalue = 1;
                        break;
                    case R.id.sgender_n:
                        sgendervalue = 0;
                        break;
                }

                RadioGroup spmhxchoose = (RadioGroup) findViewById(R.id.spmhxgroup);
                int scheckRadioButtonId_pmhx = spmhxchoose.getCheckedRadioButtonId();
                int spmhxvalue = 0;
                switch (scheckRadioButtonId_pmhx) {
                    case R.id.spmhx_y:
                        spmhxvalue = 1;
                        break;
                    case R.id.spmhx_n:
                        spmhxvalue = 0;
                        break;
                }

                RadioGroup swokechoose = (RadioGroup) findViewById(R.id.swokegroup);
                int scheckRadioButtonId_woke = swokechoose.getCheckedRadioButtonId();
                int swoke_value = 0;
                switch (scheckRadioButtonId_woke) {
                    case R.id.swoke_y:
                        swoke_value = 1;
                        break;
                    case R.id.swoke_n:
                        swoke_value = 0;
                        break;
                }

                RadioGroup swellweekb4choose = (RadioGroup) findViewById(R.id.swellweekb4group);
                int scheckRadioButtonId_wellweekb4 = swellweekb4choose.getCheckedRadioButtonId();
                int swellweekb4value = 0;
                switch (scheckRadioButtonId_wellweekb4) {
                    case R.id.swellweekb4_y:
                        swellweekb4value = 1;
                        break;
                    case R.id.swellweekb4_n:
                        swellweekb4value = 0;
                        break;
                }

                RadioGroup ssuddenchoose = (RadioGroup) findViewById(R.id.ssuddengroup);
                int scheckRadioButtonId_sudden = ssuddenchoose.getCheckedRadioButtonId();
                int ssuddenvalue = 0;
                switch (scheckRadioButtonId_sudden) {
                    case R.id.ssudden_y:
                        ssuddenvalue = 1;
                        break;
                    case R.id.ssudden_n:
                        ssuddenvalue = 0;
                        break;
                }

                RadioGroup improvechoose = (RadioGroup) findViewById(R.id.simprovegroup);
                int scheckRadioButtonId_improve = improvechoose.getCheckedRadioButtonId();
                int simprovevalue = 0;
                switch (scheckRadioButtonId_improve) {
                    case R.id.simprove_y:
                        simprovevalue = 1;
                        break;
                    case R.id.simprove_n:
                        simprovevalue = 0;
                        break;
                }

                RadioGroup sreferredchoose = (RadioGroup) findViewById(R.id.sreferredgroup);
                int scheckRadioButtonId_referred = sreferredchoose.getCheckedRadioButtonId();
                int sreferred_value = 0;
                switch (scheckRadioButtonId_referred) {
                    case R.id.sreferred_y:
                        sreferred_value = 1;
                        break;
                    case R.id.sreferred_n:
                        sreferred_value = 0;
                        break;
                }

                RadioGroup shighcategorychoose = (RadioGroup) findViewById(R.id.shighcategorygroup);
                int scheckRadioButtonId_highcategory = shighcategorychoose.getCheckedRadioButtonId();
                int shighcategory_value = 0;
                switch (scheckRadioButtonId_highcategory) {
                    case R.id.shighcategory_y:
                        shighcategory_value = 1;
                        break;
                    case R.id.shighcategory_n:
                        shighcategory_value = 0;
                        break;
                }

                RadioGroup smedicaltransportchoose = (RadioGroup) findViewById(R.id.smedicaltransportgroup);
                int scheckRadioButtonId_medicaltransport = smedicaltransportchoose.getCheckedRadioButtonId();
                int smedicaltransportvalue = 0;
                switch (scheckRadioButtonId_medicaltransport) {
                    case R.id.smedicaltransport_y:
                        smedicaltransportvalue = 1;
                        break;
                    case R.id.smedicaltransport_n:
                        smedicaltransportvalue = 0;
                        break;
                }

                RadioGroup sheadache = (RadioGroup) findViewById(R.id.sheadachegroup);
                int scheckRadioButtonId_headache = sheadache.getCheckedRadioButtonId();
                int sheadache_value = 0;
                switch (scheckRadioButtonId_headache) {
                    case R.id.sheadache_y:
                        sheadache_value = 1;
                        break;
                    case R.id.sheadache_n:
                        sheadache_value = 0;
                        break;
                }

                RadioGroup sphotophobia = (RadioGroup) findViewById(R.id.sphotophobiagroup);
                int scheckRadioButtonId_photophobia = sphotophobia.getCheckedRadioButtonId();
                int sphotophobia_value = 0;
                switch (scheckRadioButtonId_photophobia) {
                    case R.id.sphotophobia_yes:
                        sphotophobia_value = 1;
                        break;
                    case R.id.sphotophobia_no:
                        sphotophobia_value = 0;
                        break;
                }

                RadioGroup sphonophobia = (RadioGroup) findViewById(R.id.sphonophobiagroup);
                int scheckRadioButtonID_phonophobia = sphonophobia.getCheckedRadioButtonId();
                int sphonophobia_value = 0;
                switch (scheckRadioButtonID_phonophobia) {
                    case R.id.sphonophobia_yes:
                        sphonophobia_value = 1;
                        break;
                    case R.id.sphonophobia_no:
                        sphonophobia_value = 0;
                        break;
                }

                RadioGroup svomit = (RadioGroup) findViewById(R.id.svomitgroup);
                int scheckRadioButtonId_vomit = svomit.getCheckedRadioButtonId();
                int svomit_value = 0;
                switch (scheckRadioButtonId_vomit) {
                    case R.id.svomit_y:
                        svomit_value = 1;
                        break;
                    case R.id.svomit_n:
                        svomit_value = 0;
                        break;
                }

                RadioGroup sdizziness = (RadioGroup) findViewById(R.id.sdizzinessgroup);
                int scheckRadioButtonId_dizziness = sdizziness.getCheckedRadioButtonId();
                int sdizziness_value = 0;
                switch (scheckRadioButtonId_dizziness) {
                    case R.id.sdizziness_y:
                        sdizziness_value = 1;
                        break;
                    case R.id.sdizziness_n:
                        sdizziness_value = 0;
                        break;
                }

                RadioGroup sspeechloss = (RadioGroup) findViewById(R.id.sspeechlossgroup);
                int scheckRadioButtonId_speechloss = sspeechloss.getCheckedRadioButtonId();
                int sspeechloss_value = 0;
                switch (scheckRadioButtonId_speechloss) {
                    case R.id.sspeechloss_y:
                        sspeechloss_value = 1;
                        break;
                    case R.id.sspeechloss_n:
                        sspeechloss_value = 0;
                        break;
                }

                RadioGroup sfocalnumb = (RadioGroup) findViewById(R.id.sfocalnumbgroup);
                int scheckRadioButtonId_focalnumb = sfocalnumb.getCheckedRadioButtonId();
                int sfocalnumb_value = 0;
                switch (scheckRadioButtonId_focalnumb) {
                    case R.id.sfocalnumb_y:
                        sfocalnumb_value = 1;
                        break;
                    case R.id.sfocalnumb_n:
                        sfocalnumb_value = 0;
                        break;
                }

                RadioGroup sfocalweak = (RadioGroup) findViewById(R.id.sfocalweakgroup);
                int scheckRadioButtonId_focalweak = sfocalweak.getCheckedRadioButtonId();
                int sfocalweak_value = 0;
                switch (scheckRadioButtonId_focalweak) {
                    case R.id.sfocalweak_y:
                        sfocalweak_value = 1;
                        break;
                    case R.id.sfocalweak_n:
                        sfocalweak_value = 0;
                        break;
                }

                RadioGroup sseizure = (RadioGroup) findViewById(R.id.sseizuregroup);
                int scheckRadioButtonId_seizure = sseizure.getCheckedRadioButtonId();
                int sseizure_value = 0;
                switch (scheckRadioButtonId_seizure) {
                    case R.id.sseizure_y:
                        sseizure_value = 1;
                        break;
                    case R.id.sseizure_n:
                        sseizure_value = 0;
                        break;
                }

                RadioGroup smentalstate = (RadioGroup) findViewById(R.id.smentalstategroup);
                int scheckRadioButtonId_mentalstate = smentalstate.getCheckedRadioButtonId();
                int smentalstate_value = 0;
                switch (scheckRadioButtonId_mentalstate) {
                    case R.id.smentalstate_y:
                        smentalstate_value = 1;
                        break;
                    case R.id.smentalstate_n:
                        smentalstate_value = 0;
                        break;
                }

                RadioGroup sloc = (RadioGroup) findViewById(R.id.slocgroup);
                int scheckRadioButtonId_loc = sloc.getCheckedRadioButtonId();
                int sloc_value = 0;
                switch (scheckRadioButtonId_loc) {
                    case R.id.sloc_y:
                        sloc_value = 1;
                        break;
                    case R.id.sloc_n:
                        sloc_value = 0;
                        break;
                }

                RadioGroup svision = (RadioGroup) findViewById(R.id.svisiongroup);
                int scheckRadioButtonId_vision = svision.getCheckedRadioButtonId();
                int svision_value = 0;
                switch (scheckRadioButtonId_vision) {
                    case R.id.svision_y:
                        svision_value = 1;
                        break;
                    case R.id.svision_n:
                        svision_value = 0;
                        break;
                }

                RadioGroup sataxia = (RadioGroup) findViewById(R.id.sataxiagroup);
                int scheckRadioButtonId_ataxia = sataxia.getCheckedRadioButtonId();
                int sataxia_value = 0;
                switch (scheckRadioButtonId_ataxia) {
                    case R.id.sataxia_y:
                        sataxia_value = 1;
                        break;
                    case R.id.sataxia_n:
                        sataxia_value = 0;
                        break;
                }

                RadioGroup svertigo = (RadioGroup) findViewById(R.id.svertigogroup);
                int scheckRadioButtonId_vertigo = svertigo.getCheckedRadioButtonId();
                int svertigovalue = 0;
                switch (scheckRadioButtonId_vertigo) {
                    case R.id.svertigo_y:
                        svertigovalue = 1;
                        break;
                    case R.id.svertigo_n:
                        svertigovalue = 0;
                        break;
                }

                RadioGroup sother = (RadioGroup) findViewById(R.id.sothergroup);
                int scheckRadioButtonId_other = sother.getCheckedRadioButtonId();
                int sother_value = 0;
                switch (scheckRadioButtonId_other) {
                    case R.id.sother_y:
                        sother_value = 1;
                        break;
                    case R.id.sother_n:
                        sother_value = 0;
                        break;
                }

                RadioGroup spupils_group = (RadioGroup) findViewById(R.id.spupilsgroup);
                int scheckRadioButtonId_pupils = spupils_group.getCheckedRadioButtonId();
                int spupils_value = 0;
                switch (scheckRadioButtonId_pupils) {
                    case R.id.spupils_y:
                        spupils_value = 1;
                        break;
                    case R.id.spupils_n:
                        spupils_value = 0;
                        break;
                }

                RadioGroup seyeresponse_group = (RadioGroup) findViewById(R.id.sseyeresponsegroup);
                int scheckRadioButtonId_eyeresponse = seyeresponse_group.getCheckedRadioButtonId();
                int seyeresponse_value = 0;
                switch (scheckRadioButtonId_eyeresponse) {
                    case R.id.sseyeresponse1:
                        seyeresponse_value = 0;
                        break;
                    case R.id.sseyeresponse2:
                        seyeresponse_value = 1;
                        break;
                    case R.id.sseyeresponse3:
                        seyeresponse_value = 2;
                        break;
                    case R.id.seyeresponse4:
                        seyeresponse_value = 3;
                        break;
                    case R.id.sseyeresponseNT:
                        seyeresponse_value = 4;
                        break;
                }

                RadioGroup sverbalresponse_group = (RadioGroup) findViewById(R.id.ssverbalresponsegroup);
                int scheckRadioButtonId_sverbalresponse = sverbalresponse_group.getCheckedRadioButtonId();
                int sverbalresponse_value = 0;
                switch (scheckRadioButtonId_sverbalresponse) {
                    case R.id.ssverbalresponse1:
                        sverbalresponse_value = 0;
                        break;
                    case R.id.ssverbalresponse2:
                        sverbalresponse_value = 1;
                        break;
                    case R.id.ssverbalresponse3:
                        sverbalresponse_value = 2;
                        break;
                    case R.id.ssverbalresponse4:
                        sverbalresponse_value = 3;
                        break;
                    case R.id.ssverbalresponse5:
                        sverbalresponse_value = 4;
                        break;
                    case R.id.ssverbalresponseNT:
                        sverbalresponse_value = 5;
                        break;
                }

                RadioGroup smotorresponse_group = (RadioGroup) findViewById(R.id.ssmotorresponsegroup);
                int scheckRadioButtonId_smotorresponse = smotorresponse_group.getCheckedRadioButtonId();
                int smotorresponse_value = 0;
                switch (scheckRadioButtonId_smotorresponse) {
                    case R.id.ssmotorresponse1:
                        smotorresponse_value = 0;
                        break;
                    case R.id.ssmotorresponse2:
                        smotorresponse_value = 1;
                        break;
                    case R.id.ssmotorresponse3:
                        smotorresponse_value = 2;
                        break;
                    case R.id.ssmotorresponse4:
                        smotorresponse_value = 3;
                        break;
                    case R.id.ssmotorresponse5:
                        smotorresponse_value = 4;
                        break;
                    case R.id.ssmotorresponse6:
                        smotorresponse_value = 5;
                        break;
                    case R.id.ssmotorresponseNT:
                        smotorresponse_value = 6;
                        break;
                }

                RadioGroup consciousnessgroup = (RadioGroup) findViewById(R.id.sconsciousnessgroup);
                int checkRadioButtonID_consciousness = consciousnessgroup.getCheckedRadioButtonId();
                int sconsciousnesstrans_value = 0;
                switch (checkRadioButtonID_consciousness) {
                    case R.id.sconsciousness0:
                        sconsciousnesstrans_value = 0;
                        break;
                    case R.id.scousciousness1:
                        sconsciousnesstrans_value = 1;
                        break;
                    case R.id.scousciousness2:
                        sconsciousnesstrans_value = 2;
                        break;
                    case R.id.scousciousness3:
                        sconsciousnesstrans_value = 3;
                        break;
                }

                RadioGroup LOCquestiongroup = (RadioGroup) findViewById(R.id.slocquestiongroup);
                int checkRadioButtionID_LOC = LOCquestiongroup.getCheckedRadioButtonId();
                int sLOCquestions_value = 0;
                switch (checkRadioButtionID_LOC) {
                    case R.id.slocquestion0:
                        sLOCquestions_value = 0;
                        break;
                    case R.id.slocquestion1:
                        sLOCquestions_value = 1;
                        break;
                    case R.id.slocquestion2:
                        sLOCquestions_value = 2;
                        break;
                }

                RadioGroup LOCcommandsgroup = (RadioGroup) findViewById(R.id.sloccommandgroup);
                int checkRadioButtonID_LOCcommands = LOCcommandsgroup.getCheckedRadioButtonId();
                int sLOCcommandstrans_value = 0;
                switch (checkRadioButtonID_LOCcommands) {
                    case R.id.sloccommand0:
                        sLOCcommandstrans_value = 0;
                        break;
                    case R.id.sloccommand1:
                        sLOCcommandstrans_value = 1;
                        break;
                    case R.id.sloccommand2:
                        sLOCcommandstrans_value = 2;
                        break;
                }

                RadioGroup Bestgazegroup = (RadioGroup) findViewById(R.id.sbestgazegroup);
                int checkRadioButtonID_Bestgaze = Bestgazegroup.getCheckedRadioButtonId();
                int sBestgazetrans_value = 0;
                switch (checkRadioButtonID_Bestgaze) {
                    case R.id.sbestgaze0:
                        sBestgazetrans_value = 0;
                        break;
                    case R.id.sbestgaze1:
                        sBestgazetrans_value = 1;
                        break;
                    case R.id.sbestgaze2:
                        sBestgazetrans_value = 2;
                        break;
                }

                RadioGroup visualfieldsgroup = (RadioGroup) findViewById(R.id.svisualgroup);
                int checkRadioBUttonID_visualfieldsgroup = visualfieldsgroup.getCheckedRadioButtonId();
                int svisualtrans_value = 0;
                switch (checkRadioBUttonID_visualfieldsgroup) {
                    case R.id.svisual0:
                        svisualtrans_value = 0;
                        break;
                    case R.id.svisual1:
                        svisualtrans_value = 1;
                        break;
                    case R.id.svisual2:
                        svisualtrans_value = 2;
                        break;
                    case R.id.svisual3:
                        svisualtrans_value = 3;
                        break;
                }

                RadioGroup facialparesisgroup = (RadioGroup) findViewById(R.id.sfacialgroup);
                int checkRadioButtonID_facialparesisgroup = facialparesisgroup.getCheckedRadioButtonId();
                int sfacialparesisgroup_value = 0;
                switch (checkRadioButtonID_facialparesisgroup) {
                    case R.id.sfacial0:
                        sfacialparesisgroup_value = 0;
                        break;
                    case R.id.sfacial1:
                        sfacialparesisgroup_value = 1;
                        break;
                    case R.id.sfacial2:
                        sfacialparesisgroup_value = 2;
                        break;
                    case R.id.sfacial3:
                        sfacialparesisgroup_value = 3;
                        break;
                }

                RadioGroup leftarmgroup = (RadioGroup) findViewById(R.id.sleftarm);
                int checkRadioButtonID_leftarm = leftarmgroup.getCheckedRadioButtonId();
                int leftarmtrans_value = 0;
                switch (checkRadioButtonID_leftarm) {
                    case R.id.sleftarm0:
                        leftarmtrans_value = 0;
                        break;
                    case R.id.sleftarm1:
                        leftarmtrans_value = 1;
                        break;
                    case R.id.sleftarm2:
                        leftarmtrans_value = 2;
                        break;
                    case R.id.sleftarm3:
                        leftarmtrans_value = 3;
                        break;
                    case R.id.sleftarm4:
                        leftarmtrans_value = 4;
                        break;
                    case R.id.sleftarm5:
                        leftarmtrans_value = 0;
                        break;
                }

                RadioGroup rightarmgroup = (RadioGroup) findViewById(R.id.srightarm);
                int checkRadioButtonID_rightarm = rightarmgroup.getCheckedRadioButtonId();
                int rightarmtrans_value = 0;
                switch (checkRadioButtonID_rightarm) {
                    case R.id.srightarm0:
                        rightarmtrans_value = 0;
                        break;
                    case R.id.srightarm1:
                        rightarmtrans_value = 1;
                        break;
                    case R.id.srightarm2:
                        rightarmtrans_value = 2;
                        break;
                    case R.id.srightarm3:
                        rightarmtrans_value = 3;
                        break;
                    case R.id.srightarm4:
                        rightarmtrans_value = 4;
                        break;
                    case R.id.srightarm5:
                        rightarmtrans_value = 0;
                        break;
                }

                RadioGroup sweakhand_group = (RadioGroup) findViewById(R.id.sweakhandgroup);
                int scheckRadioButtonId_weakhand = sweakhand_group.getCheckedRadioButtonId();
                int sweakhand_value = 0;
                switch (scheckRadioButtonId_weakhand) {
                    case R.id.sweakhand_y:
                        sweakhand_value = 1;
                        break;
                    case R.id.sweakhand_n:
                        sweakhand_value = 0;
                        break;
                }

                RadioGroup leftleggroup = (RadioGroup) findViewById(R.id.sleftleg);
                int checkRadioButtonID_leftleg = leftleggroup.getCheckedRadioButtonId();
                int leftlegtrans_value = 0;
                switch (checkRadioButtonID_leftleg) {
                    case R.id.sleftleg0:
                        leftlegtrans_value = 0;
                        break;
                    case R.id.sleftleg1:
                        leftlegtrans_value = 1;
                        break;
                    case R.id.sleftleg2:
                        leftlegtrans_value = 2;
                        break;
                    case R.id.sleftleg3:
                        leftlegtrans_value = 3;
                        break;
                    case R.id.sleftleg4:
                        leftlegtrans_value = 4;
                        break;
                    case R.id.sleftleg5:
                        leftlegtrans_value = 0;
                        break;
                }

                RadioGroup rightleggroup = (RadioGroup) findViewById(R.id.srightleg);
                int checkRadioButtonID_rightleg = rightleggroup.getCheckedRadioButtonId();
                int rightlegtrans_value = 0;
                switch (checkRadioButtonID_rightleg) {
                    case R.id.srightleg0:
                        rightlegtrans_value = 0;
                        break;
                    case R.id.srightleg1:
                        rightlegtrans_value = 1;
                        break;
                    case R.id.srightleg2:
                        rightlegtrans_value = 2;
                        break;
                    case R.id.srightleg3:
                        rightlegtrans_value = 3;
                        break;
                    case R.id.srightleg4:
                        rightlegtrans_value = 4;
                        break;
                    case R.id.srightleg5:
                        rightlegtrans_value = 0;
                        break;
                }

                RadioGroup limbataxiagroup = (RadioGroup) findViewById(R.id.slimbataxia);
                int checkRadioButtonID_limbataxia = limbataxiagroup.getCheckedRadioButtonId();
                int limbataxiatrans_value = 0;
                switch (checkRadioButtonID_limbataxia) {
                    case R.id.slimbataxia0:
                        limbataxiatrans_value = 0;
                        break;
                    case R.id.slimbataxia1:
                        limbataxiatrans_value = 1;
                        break;
                    case R.id.slimbataxia2:
                        limbataxiatrans_value = 2;
                        break;
                    case R.id.slimbataxia3:
                        limbataxiatrans_value = 9;
                        break;
                }

                RadioGroup ssensearm_group = (RadioGroup) findViewById(R.id.ssensearmgroup);
                int scheckRadioButtonId_sensearm = ssensearm_group.getCheckedRadioButtonId();
                int ssensearm_value = 0;
                switch (scheckRadioButtonId_sensearm) {
                    case R.id.ssensearm_y:
                        ssensearm_value = 1;
                        break;
                    case R.id.ssensearm_n:
                        ssensearm_value = 0;
                        break;
                }

                RadioGroup ssenseleg_group = (RadioGroup) findViewById(R.id.ssenseleggroup);
                int scheckRadioButtonId_senseleg = ssenseleg_group.getCheckedRadioButtonId();
                int ssenseleg_value = 0;
                switch (scheckRadioButtonId_senseleg) {
                    case R.id.ssenseleg_y:
                        ssenseleg_value = 1;
                        break;
                    case R.id.ssenseleg_n:
                        ssenseleg_value = 0;
                        break;
                }

                RadioGroup ssenseface_group = (RadioGroup) findViewById(R.id.ssenseface_group);
                int scheckRadioButtonId_senseface = ssenseface_group.getCheckedRadioButtonId();
                int ssenseface_value = 0;
                switch (scheckRadioButtonId_senseface) {
                    case R.id.ssenseface_y:
                        ssenseface_value = 1;
                        break;
                    case R.id.ssenseface_n:
                        ssenseface_value = 0;
                        break;
                }

                RadioGroup sensorygroup = (RadioGroup) findViewById(R.id.ssensory);
                int checkRadioButtonID_sensory = sensorygroup.getCheckedRadioButtonId();
                int sensorytrans_value = 0;
                switch (checkRadioButtonID_sensory) {
                    case R.id.ssensory0:
                        sensorytrans_value = 0;
                        break;
                    case R.id.ssensory1:
                        sensorytrans_value = 1;
                        break;
                    case R.id.ssensory2:
                        sensorytrans_value = 2;
                        break;
                }

                RadioGroup languagegroup = (RadioGroup) findViewById(R.id.slanguage);
                int checkRadioButton_language = languagegroup.getCheckedRadioButtonId();
                int languagetrans_value = 0;
                switch (checkRadioButton_language) {
                    case R.id.slanguage0:
                        languagetrans_value = 0;
                        break;
                    case R.id.slanguage1:
                        languagetrans_value = 1;
                        break;
                    case R.id.slanguage2:
                        languagetrans_value = 2;
                        break;
                }

                RadioGroup dysarthriagroup = (RadioGroup) findViewById(R.id.sdysarthriatext);
                int checkRadioButton_dysarthria = dysarthriagroup.getCheckedRadioButtonId();
                int dysarthriatrans_value = 0;
                switch (checkRadioButton_dysarthria) {
                    case R.id.sdysarthria0:
                        dysarthriatrans_value = 0;
                        break;
                    case R.id.sdysarthria1:
                        dysarthriatrans_value = 1;
                        break;
                    case R.id.sdysarthria2:
                        dysarthriatrans_value = 2;
                        break;
                    case R.id.sdysarthria3:
                        dysarthriatrans_value = 3;
                        break;
                }

                RadioGroup extinctiongroup = (RadioGroup) findViewById(R.id.sextinction_text);
                int checkRadioButton_extinction = extinctiongroup.getCheckedRadioButtonId();
                int extinctiontrans_value = 0;
                switch (checkRadioButton_extinction) {
                    case R.id.sextinction0:
                        extinctiontrans_value = 0;
                        break;
                    case R.id.srightleg2:
                        extinctiontrans_value = 1;
                        break;
                    case R.id.sextinction2:
                        extinctiontrans_value = 2;
                        break;
                }

                RadioGroup ssenseneg_group = (RadioGroup) findViewById(R.id.ssenseneggroup);
                int scheckRadioButtonId_senseneg = ssenseneg_group.getCheckedRadioButtonId();
                int ssenseneg_value = 0;
                switch (scheckRadioButtonId_senseneg) {
                    case R.id.ssenseneg_y:
                        ssenseneg_value = 1;
                        break;
                    case R.id.ssenseneg_n:
                        ssenseneg_value = 0;
                        break;
                }

                RadioGroup swalknotokcrf2_group = (RadioGroup) findViewById(R.id.swalknotokcrf2group);
                int scheckRadioButtonId_walknotokcrf2 = swalknotokcrf2_group.getCheckedRadioButtonId();
                int swalknotokcrf2_value = 0;
                switch (scheckRadioButtonId_walknotokcrf2) {
                    case R.id.swalknotokcrf2_y:
                        swalknotokcrf2_value = 1;
                        break;
                    case R.id.swalknotokcrf2_n:
                        swalknotokcrf2_value = 0;
                        break;
                }

                RadioGroup sother2_group = (RadioGroup) findViewById(R.id.sother2group);
                int scheckRadioButtonId_other2 = sother2_group.getCheckedRadioButtonId();
                int sother2_value = 0;
                switch (scheckRadioButtonId_other2) {
                    case R.id.sother2_y:
                        sother2_value = 1;
                        break;
                    case R.id.sother2_n:
                        sother2_value = 0;
                        break;
                }

                RadioGroup sdysarghria_group = (RadioGroup) findViewById(R.id.sdyphasiagroup);
                int scheckRadioButtonID_sdysarghria = sdysarghria_group.getCheckedRadioButtonId();
                int sdysarghria_value = 0;
                switch (scheckRadioButtonID_sdysarghria) {
                    case R.id.sdyphasia0:
                        sdysarghria_value = 0;
                        break;
                    case R.id.sdyphasia1:
                        sdysarghria_value = 1;
                        break;
                    case R.id.sdyphasia2:
                        sdysarghria_value = 2;
                        break;
                    case R.id.sdyphasia3:
                        sdysarghria_value = 3;
                        break;
                }

                int upface;
                if (sfacialparesisgroup_value == 3) {
                    upface = 1;
                } else {
                    upface = 0;
                }

                int visualtrans_value;
                if (svisualtrans_value == 0) {
                    visualtrans_value = 0;
                } else {
                    visualtrans_value = 1;
                }

                if (spupils_value == 0 && seyeresponse_value == 0 && sverbalresponse_value == 0 && smotorresponse_value == 0 && sconsciousnesstrans_value == 0
                        && sLOCquestions_value == 0 && sLOCcommandstrans_value == 0 && sBestgazetrans_value == 0 && svisualtrans_value == 0 && sfacialparesisgroup_value == 0 &&
                        leftarmtrans_value == 0 && rightarmtrans_value == 0 && sweakhand_value == 0 && leftlegtrans_value == 0 && rightlegtrans_value == 0 &&
                        limbataxiatrans_value == 0 && ssenseface_value == 0 && ssenseleg_value == 0 && ssenseface_value == 0 && sensorytrans_value == 0 &&
                        languagetrans_value == 0 && sdysarghria_value == 0 && extinctiontrans_value == 0 && ssenseneg_value == 0 && swalknotokcrf2_value == 0) {
                    noneuro = 1;
                } else {
                    noneuro = 0;
                }

                if (GCSscore < 9) {
                    lowgcs = 1;
                } else {
                    lowgcs = 0;
                }

                if (GCSscore < 15) {
                    group_abngcs = 0;
                } else {
                    group_abngcs = 1;
                }

                /* eye movement*/
                int eyemovement;
                if (sBestgazetrans_value == 0) {
                    eyemovement = 0;
                } else {
                    eyemovement = 1;
                }

                /*visualdef*/
                int visualdef;
                if (visualtrans_value == 0) {
                    visualdef = 0;
                } else {
                    visualdef = 1;
                }

                /*weakface*/
                int weakface;
                if (sfacialparesisgroup_value == 0) {
                    weakface = 0;
                } else {
                    weakface = 1;
                }

                /*weakarm*/
                int weakarm;
                if (leftarmtrans_value == 0 && rightarmtrans_value == 0) {
                    weakarm = 0;
                } else {
                    weakarm = 1;
                }

                /*weakleg*/
                int weakleg;
                if (leftarmtrans_value == 0 && rightlegtrans_value == 0) {
                    weakleg = 0;
                } else {
                    weakleg = 1;
                }

                /*ataxia*/
                int ataxia1;
                if (limbataxiatrans_value == 0) {
                    ataxia1 = 0;
                } else {
                    ataxia1 = 1;
                }

                /*dysphasia*/
                int dysphasia_symptom;
                if (languagetrans_value == 0) {
                    dysphasia_symptom = 0;
                } else {
                    dysphasia_symptom = 1;
                }

                /*dysathria*/
                int dysaphsia_symptom;
                if (sdysarghria_value == 0) {
                    dysaphsia_symptom = 0;
                } else {
                    dysaphsia_symptom = 1;
                }

                /*
        ANY OF ABOVE =1)

41. grsi_motorpos: ANY FOCAL MOTOR SIGN 1=yes 0=no .a=NA .=missing (DERIVED ==1 IF ITEMS 18 OR 21 OR 22 OR 25 =1) weakface weakarm weakhand weakleg

42. grsi_sensepos: ANY FOCAL SENSORY SIGN 1=yes 0=no .a=NA .=missing (DERIVED ==1 IF ITEMS 28 OR 29 OR 30 =1) sensearm  senseleg senseface

43. grsi_speechpos: ANY SPEECH DEFICIT 1=yes 0=no .a=NA .=missing (DERIVED ==1 IF ITEMS 33 OR 35 =1) dysphas dysarth

44. grsi_otherpos: ANY OTHER NEUROLOGICAL DEFICIT 1=yes 0=no .a=NA .=missing (DERIVED ==1 IF ITEMS 1 OR 7 OR 12 OR 14 OR 27 OR 37 OR 38 OR 39=1)

pupils group_abngcs eyemovemt visualdef ataxia1 senseneg walknotokcrf2 other2

45. grsi_signpos: ANY FOCAL NEUROLOGICAL SIGN 1=yes 0=no .a=NA .=missing (DERIVED ==0 IF ANY OF ABOVE =0. ==1 IF ANY OF ABOVE =1) - any of the above = 0, any of the above = 1,
         */

                /**
                 * Definition of grouped signs
                 * group_abngcs           - Abnormal Glasgow coma score, ranging from [1,15)
                 */
                /**  int gspeechpos       = intent.getIntExtra("gspeechpos", 0);
                 int gmotorpos        = intent.getIntExtra("gmotorpos", 0);
                 int lowgcs          = intent.getIntExtra("lowgcs", 0);
                 int gotherpos        = intent.getIntExtra("gotherpos", 0);
                 int gsensepos        = intent.getIntExtra("gsensepos", 0);
                 int gsignpos         = intent.getIntExtra("gsignpos", 0);
                 */

                int gmotorpos;
                if (weakface == 0 || weakarm == 0 || sweakhand_value == 0 || weakleg == 0) {
                    gmotorpos = 0;
                } else {
                    gmotorpos = 1;
                }

                int gsensepos;
                if (ssensearm_value == 0 || ssenseleg_value == 0 || ssenseface_value == 0) {
                    gsensepos = 0;
                } else {
                    gsensepos = 1;
                }

                int gspeechpos;
                if (dysaphsia_symptom == 0 || dysaphsia_symptom == 0) {
                    gspeechpos = 0;
                } else {
                    gspeechpos = 1;
                }

                int gotherpos;
                if (spupils_value == 0 || group_abngcs == 0 || eyemovement == 0 || visualdef == 0 || ataxia1 == 0 || ssenseneg_value == 0 ||
                        swalknotokcrf2_value == 0 || sother2_value == 0) {
                    gotherpos = 0;
                } else {
                    gotherpos = 1;
                }

                int gsignpos;
                if (spupils_value == 0 && eyemovement == 0 && lowgcs == 0 && visualdef == 0 && weakarm == 0 && weakface == 0 && weakleg == 0 &&
                        sweakhand_value == 0 && ataxia1 == 0 && ssensearm_value == 0 && ssenseleg_value == 0 && ssenseface_value == 0 &&
                        dysaphsia_symptom == 0 && dysphasia_symptom == 0 && swalknotokcrf2_value == 0 && sother2_value == 0 && noneuro == 0) {
                    gsignpos = 0;
                } else {
                    if (spupils_value == 0 || eyemovement == 0 || lowgcs == 0 || visualdef == 0 || weakarm == 0 || weakface == 0 || weakleg == 0 || sweakhand_value == 0 ||
                            ataxia1 == 0 || ssensearm_value == 0 || ssenseleg_value == 0 || ssenseface_value == 0 || dysaphsia_symptom == 0 || dysphasia_symptom == 0 ||
                            swalknotokcrf2_value == 0 || sother2_value == 0 || noneuro == 0) {
                        gsignpos = 1;
                    } else {
                        gsignpos = 2;
                    }
                }

        /*calculate the value of nonneuro
        int si_nonneuro = 0;
        if (pupils != 0 || abngcs  != 0 || lowGCS != 0  || walknotokcrf2 != 0 ||  weakhand != 0 || sensearm  != 0 ||  senseleg  != 0 ||  senseface != 0 || eyemovement   != 0 || dysarthria  != 0 || dysphasia1  != 0 || visualdef  != 0 || ataxia1 != 0 ||  other2 != 0 ||
        eyeresponse != 0 || verbalresponse  != 0 || motorresponse  != 0 || upface != 0 || lowface != 0 || visualtrans_value != 0 || LOC != 0 || extinction != 0 || language != 0 ||  bestgaze != 0 || consciousness != 0 || facialpalsy != 0 || leftarm != 0 || leftleg != 0 ||
                limbataxia != 0 || LOCcommands != 0 || rightleg != 0 || rightarm != 0 ||  sensory != 0 ||  visual != 0 ||  dysphasia1!= 0 ||  dysathria1 != 0){
            si_nonneuro = 1;
        } else {
            si_nonneuro = 0;
        }
        */

                /**
                 * Definition of PeDNIHSS Score (PeDNIHSS)
                 */

                int PeDNIHSS = 0;

                /**
                 * Definition of individual model's probability
                 */
                double cart_mimics_model1 = 0;
                double cart_mimics_model2 = 0;
                double cart_mimics_model3 = 0;
                double cart_mimics_model4 = 0;
                double cart_mimics_model5 = 0;
                double cart_mimics_model6 = 0;
                double cart_ischaemic_model1 = 0;
                double cart_ischaemic_model2 = 0;
                double cart_ischaemic_model3 = 0;
                double cart_ischaemic_model4 = 0;
                double cart_ischaemic_model5 = 0;
                double cart_ischaemic_model6 = 0;
                double cart_haemorrhagic_model1 = 0;
                double cart_haemorrhagic_model2 = 0;
                double cart_haemorrhagic_model3 = 0;
                double cart_haemorrhagic_model4 = 0;
                double cart_haemorrhagic_model5 = 0;
                double cart_haemorrhagic_model6 = 0;
                double nb_mimics_model1 = 0;
                double nb_mimics_model3 = 0;
                double nb_mimics_model4 = 0;
                double nb_mimics_model5 = 0;
                double nb_mimics_model6 = 0;
                double nb_mimics_model2 = 0;
                double nb_ischaemic_model1 = 0;
                double nb_ischaemic_model2 = 0;
                double nb_ischaemic_model3 = 0;
                double nb_ischaemic_model4 = 0;
                double nb_ischaemic_model5 = 0;
                double nb_ischaemic_mode6 = 0;
                double nb_haemorrhagic_model1 = 0;
                double nb_haemorrhagic_model2 = 0;
                double nb_haemorrhagic_model3 = 0;
                double nb_haemorrhagic_model4 = 0;
                double nb_haemorrhagic_model5 = 0;
                double nb_haemorrhagic_model6 = 0;

                /**
                 * Definition of ensemble model's probability
                 */
                double buckets_mimics_cart = 0;
                double buckets_haemorrhagic_cart = 0;
                double buckets_ischaemic_cart = 0;
                double stacking_mimics_cart = 0;
                double stacking_haemorrhagic_cart = 0;
                double stacking_ischaemic_cart = 0;
                double buckets_mimics_nb = 0;
                double buckets_haemorrhagic_nb = 0;
                double buckets_ischaemic_nb = 0;
                double stacking_mimics_nb = 0;
                double stacking_haemorrhagic_nb = 0;
                double stacking_ischaemic_nb = 0;

                double probability_mimics = 0;
                double probability_hstroke = 0;
                double probability_ischaemic = 0;

                /**
                 * CART model for classification of stroke mimics
                 */

                if (sother_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1) {
                    cart_mimics_model1 = 0.17;
                } else {
                    if (sother_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1 && sdizziness_value == 0 && sseizure_value == 0 && spmhxvalue == 0) {
                        cart_mimics_model1 = 0.12;
                    } else {
                        if (sother_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1 && sdizziness_value == 0 && sseizure_value == 0 && spmhxvalue == 1) {
                            cart_mimics_model1 = 0.75;
                        } else {
                            if (sother_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1 && sdizziness_value == 0 && sseizure_value == 1) {
                                cart_mimics_model1 = 0.74;
                            } else {
                                if (sother_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1 && sdizziness_value == 1) {
                                    cart_mimics_model1 = 0.94;
                                } else {
                                    if (sother_value == 0 && smedicaltransportvalue == 1 && smentalstate_value == 1) {
                                        cart_mimics_model1 = 0.37;
                                    } else {
                                        if (sother_value == 0 && smedicaltransportvalue == 1 && smentalstate_value == 0 && sspeechloss_value == 1 && sfocalweak_value == 0) {
                                            cart_mimics_model1 = 0.42;
                                        } else {
                                            if ((sother_value == 0 && smedicaltransportvalue == 1 && smentalstate_value == 0 && sspeechloss_value == 1 && sfocalweak_value == 1)) {
                                                cart_mimics_model1 = 0.89;
                                            } else {
                                                if (sother_value == 1) {
                                                    cart_mimics_model1 = 0.94;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                /**
                 * CART model for classification of ischaemic stroke
                 */

                if (sfocalweak_value == 0) {
                    cart_ischaemic_model1 = 0.07;
                } else {
                    if (sfocalweak_value == 1 && sspeechloss_value == 0) {
                        cart_ischaemic_model1 = 0.18;
                    } else {
                        if (sfocalweak_value == 1 && sspeechloss_value == 0 && ataxia1 == 0) {
                            cart_ischaemic_model1 = 0.3;
                        } else {
                            if (sfocalweak_value == 1 && sspeechloss_value == 0 && ataxia1 == 1 && sfocalnumb_value == 1) {
                                cart_ischaemic_model1 = 0.37;
                            } else {
                                cart_ischaemic_model1 = 0.82;
                            }
                        }
                    }
                }

                /**
                 * CART model for classification of haemorrhagic stroke
                 */

                if (shighcategory_value == 0) {
                    cart_haemorrhagic_model1 = 0.05;
                } else {
                    if (sloc_value == 0) {
                        if (sdizziness_value == 1) {
                            cart_haemorrhagic_model1 = 0;
                        } else {
                            if (svomit_value == 0) {
                                cart_haemorrhagic_model1 = 0.13;
                            } else {
                                if (sreferred_value == 0) {
                                    cart_haemorrhagic_model1 = 0.2;
                                } else {
                                    cart_haemorrhagic_model1 = 0.57;
                                }
                            }
                        }
                    } else {
                        cart_haemorrhagic_model1 = 0.53;
                    }
                }

                /**
                 * CART model 2 for classification of stroke mimics
                 */
                if (gspeechpos == 1 && gmotorpos == 1) {
                    cart_mimics_model2 = 0.31;
                } else {
                    if (gspeechpos == 1 && gmotorpos == 0) {
                        cart_mimics_model2 = 0.71;
                    }
                    if (gspeechpos == 0 && shighcategory_value == 1 && swoke_value == 0 && gmotorpos == 1) {
                        cart_mimics_model2 = 0.25;
                    } else {
                        if (gspeechpos == 0 && shighcategory_value == 1 && swoke_value == 0 && swellweekb4value == 1 && gmotorpos == 0 && lowgcs == 1) {
                            cart_mimics_model2 = 0.14;
                        } else {
                            if (gspeechpos == 0 && shighcategory_value == 1 && swoke_value == 0 && swellweekb4value == 1 && gmotorpos == 0 && lowgcs == 0) {
                                cart_mimics_model2 = 0.64;
                            } else {
                                if (gspeechpos == 0 && shighcategory_value == 1 && swoke_value == 0 && swellweekb4value == 0) {
                                    cart_mimics_model2 = 0.8;
                                } else {
                                    if (gspeechpos == 0 && shighcategory_value == 1 && swoke_value == 1) {
                                        cart_mimics_model2 = 0.87;
                                    } else {
                                        if (sspeechloss_value == 0 && shighcategory_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 1) {
                                            cart_mimics_model2 = 0.37;
                                        } else {
                                            if (sspeechloss_value == 0 && shighcategory_value == 0 && smedicaltransportvalue == 1 && sreferred_value == 0) {
                                                cart_mimics_model2 = 0.82;
                                            } else {
                                                if (sspeechloss_value == 0 && shighcategory_value == 0 && smedicaltransportvalue == 0) {
                                                    cart_mimics_model2 = 0.91;
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                /**
                 * CART model 2 for classification of ischaemic stroke
                 */
                if (gmotorpos == 0) {
                    cart_ischaemic_model2 = 0.05;
                } else {
                    if (gspeechpos == 0) {
                        if (smedicaltransportvalue == 0) {
                            cart_ischaemic_model2 = 0.15;
                        } else {
                            if (swellweekb4value == 0) {
                                cart_ischaemic_model2 = 0.09;
                            } else {
                                if (sgendervalue == 0) {
                                    cart_ischaemic_model2 = 0.33;
                                } else {
                                    cart_ischaemic_model2 = 0.73;
                                }
                            }
                        }
                    } else {
                        if (gotherpos == 1) {
                            cart_ischaemic_model2 = 0.45;
                        } else {
                            cart_ischaemic_model2 = 0.71;
                        }
                    }
                    if (gmotorpos == 0) {
                        cart_ischaemic_model2 = 0.05;
                    } else {
                        if (gmotorpos == 0 && gspeechpos == 0 && smedicaltransportvalue == 0) {
                            cart_ischaemic_model2 = 0.15;
                        } else {
                            if (gmotorpos == 0 && gspeechpos == 0 && smedicaltransportvalue == 1 && swellweekb4value == 0) {
                                cart_ischaemic_model2 = 0.09;
                            } else {
                                if (gmotorpos == 0 && gspeechpos == 0 && smedicaltransportvalue == 1 && swellweekb4value == 1 && sgendervalue == 0) {
                                    cart_ischaemic_model2 = 0.33;
                                } else {
                                    if (gmotorpos == 0 && gspeechpos == 0 && smedicaltransportvalue == 1 && swellweekb4value == 1 && sgendervalue == 1) {
                                        cart_ischaemic_model2 = 0.73;
                                    } else {
                                        if (gmotorpos == 0 && gspeechpos == 0 && gotherpos == 1) {
                                            cart_ischaemic_model2 = 0.45;
                                        } else {
                                            if (gmotorpos == 0 && gspeechpos == 0 && gotherpos == 0) {
                                                cart_ischaemic_model2 = 0.71;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        /**
                         * CART model 2 for classification of haemorrhagic stroke
                         */
                        if (lowgcs == 0) {
                            if (smedicaltransportvalue == 0) {
                                cart_haemorrhagic_model2 = 0.03;
                            } else {
                                if (gmotorpos == 1) {
                                    cart_haemorrhagic_model2 = 0.05;
                                } else {
                                    if (sreferred_value == 0) {
                                        cart_haemorrhagic_model2 = 0.11;
                                    } else {
                                        cart_haemorrhagic_model2 = 0.54;
                                    }
                                }
                            }
                        } else {
                            if (gmotorpos == 1) {
                                cart_haemorrhagic_model2 = 0.22;
                            } else {
                                cart_haemorrhagic_model2 = 0.64;
                            }
                        }

                        // CART model3 of stroke mimics classification
                        if (sweakhand_value == 1) {
                            if (sother_value == 0) {
                                if (weakface == 1) {
                                    cart_mimics_model3 = 0.19;
                                } else {
                                    cart_mimics_model3 = 0.59;
                                }
                            } else {
                                cart_mimics_model3 = 1;
                            }
                        } else {
                            if (spupils_value == 1) {
                                cart_mimics_model3 = 0.39;
                            } else {
                                if (sother_value == 0) {
                                    if (sspeechloss_value == 1) {
                                        if (weakface == 1) {
                                            cart_mimics_model3 = 0.35;
                                        } else {
                                            cart_mimics_model3 = 0.84;
                                        }
                                    } else {
                                        cart_mimics_model3 = 0.84;
                                    }
                                } else {
                                    cart_mimics_model3 = 0.93;
                                }
                            }
                        }

                        /**
                         *  CART model 3 for classification of haemorrhagic  stroke
                         */

                        // CART model3 of haemorrhagic stroke classification
                        if (spupils_value == 0) {
                            if (sfocalweak_value == 1) {
                                cart_haemorrhagic_model3 = 0.03;
                            } else {
                                if (sfocalnumb_value == 1) {
                                    cart_haemorrhagic_model3 = 0;
                                } else {
                                    if (sdizziness_value == 1) {
                                        cart_haemorrhagic_model3 = 0.04;
                                    } else {
                                        if (eyemovement == 1) {
                                            cart_haemorrhagic_model3 = 0;
                                        } else {
                                            cart_haemorrhagic_model3 = 0.18;
                                        }
                                    }
                                }
                            }
                        } else {
                            cart_haemorrhagic_model3 = 0.55;
                        }

                        //CART model3 of ischaemic stroke classification
                        if (weakarm == 0) {
                            if (sspeechloss_value == 0) {
                                cart_ischaemic_model3 = 0.04;
                            } else {
                                if (weakface == 0) {
                                    cart_ischaemic_model3 = 0.03;
                                } else {
                                    cart_ischaemic_model3 = 0.62;
                                }
                            }
                        } else {
                            if (weakface == 0) {
                                cart_ischaemic_model3 = 0.22;
                            } else {
                                if (svomit_value == 1) {
                                    cart_ischaemic_model3 = 0.33;
                                } else {
                                    cart_ischaemic_model3 = 0.82;
                                }
                            }
                        }

                        /**
                         * CART model 4 for classification of stroke mimics
                         */
                        if (sother_value == 0) {
                            if (sspeechloss_value == 1) {
                                cart_mimics_model4 = 0.28;
                            } else {
                                if (lowgcs == 1) {
                                    cart_mimics_model4 = 0.36;
                                } else {
                                    if (gmotorpos == 1) {
                                        if (sspeechloss_value == 1) {
                                            cart_mimics_model4 = 0.36;
                                        } else {
                                            cart_mimics_model4 = 0.77;
                                        }
                                    } else {
                                        cart_mimics_model4 = 0.82;
                                    }
                                }
                            }
                        } else {
                            cart_mimics_model4 = 0.94;
                        }

                        /**
                         * CART model 4 for classification of haemorrhagic stroke
                         */
                        if (lowgcs == 0) {
                            cart_haemorrhagic_model4 = 0.07;
                        } else {
                            if (sfocalweak_value == 1) {
                                cart_haemorrhagic_model4 = 0.18;
                            } else {
                                cart_haemorrhagic_model4 = 0.75;
                            }
                        }

                        /**
                         * CART model 4 for classification of ischaemic stroke
                         */
                        if (gmotorpos == 0) {
                            cart_ischaemic_model4 = 0.05;
                        } else {
                            if (sother_value == 1) {
                                cart_haemorrhagic_model4 = 0;
                            } else {
                                if (sspeechloss_value == 0) {
                                    if (visualdef == 1) {
                                        cart_haemorrhagic_model4 = 0;
                                    } else {
                                        cart_haemorrhagic_model4 = 0.27;
                                    }
                                } else {
                                    if (svomit_value == 1) {
                                        cart_haemorrhagic_model4 = 0.37;
                                    } else {
                                        cart_haemorrhagic_model4 = 0.76;
                                    }
                                }
                            }
                        }

                        /**
                         * CART model 5 for classification of stroke mimics
                         */
                        if (sweakhand_value == 1) {
                            if (weakface == 1) {
                                cart_mimics_model5 = 0.22;
                            } else {
                                cart_mimics_model5 = 0.68;
                            }
                        } else {
                            if (dysaphsia_symptom == 1) {
                                cart_mimics_model5 = 0.55;
                            } else {
                                cart_mimics_model5 = 0.84;
                            }
                        }

                        /**
                         * CART model 5 for classification of haemorrhagic stroke - N/A
                         */

                        /**
                         * CART model 5 for classification of ischaemic stroke
                         */
                        if (weakarm == 0) {
                            cart_ischaemic_model5 = 0.06;
                        } else {
                            if (weakface == 0) {
                                cart_ischaemic_model5 = 0.22;
                            } else {
                                cart_ischaemic_model5 = 0.71;
                            }
                        }

                        /**
                         * CART model 6 for classification of stroke mimics
                         */
                        if (sweakhand_value == 1) {
                            if (weakface == 1) {
                                cart_mimics_model6 = 0.22;
                            } else {
                                cart_mimics_model6 = 0.68;
                            }
                        } else {
                            if (lowgcs == 1) {
                                cart_mimics_model6 = 0.46;
                            } else {
                                if (dysaphsia_symptom == 1) {
                                    cart_mimics_model6 = 0.6;
                                } else {
                                    cart_mimics_model6 = 0.86;
                                }
                            }
                        }

                        /**
                         * CART model 6 for classification of haemorrhagic stroke
                         */
                        if (lowgcs == 0) {
                            cart_haemorrhagic_model6 = 0.07;
                            if (sspeechloss_value == 1) {
                                cart_haemorrhagic_model6 = 0.25;
                            } else {
                                cart_haemorrhagic_model6 = 0.6;
                            }
                        }

                        /**
                         * CART model 6 for classification of ischaemic stroke
                         */
                        if (weakarm == 0) {
                            cart_ischaemic_model6 = 0.06;
                        } else {
                            if (weakface == 0) {
                                cart_ischaemic_model6 = 0.22;
                            } else {
                                cart_ischaemic_model6 = 0.71;
                            }
                        }

                        /**
                         * Naive Bayes model for classification of stroke mimics
                         */
                        if (sreferred_value == 0) {
                            if (ssuddenvalue == 0) {
                                if (spmhxvalue == 0) {
                                    if (sgendervalue == 0) {
                                        nb_mimics_model1 = 0.87;
                                    } else {
                                        nb_mimics_model1 = 0.86;
                                    }
                                } else {
                                    if (sheadache_value == 0) {
                                        nb_mimics_model1 = 0.8;
                                    } else {
                                        nb_mimics_model1 = 0.76;
                                    }
                                }
                            } else {
                                if (shighcategory_value == 0) {
                                    if (sseizure_value == 0) {
                                        if (sfocalnumb_value == 0) {
                                            if (visualdef == 0) {
                                                if (sspeechloss_value == 0) {
                                                    if (smedicaltransportvalue == 0) {
                                                        nb_mimics_model1 = 0.88;
                                                    } else {
                                                        nb_mimics_model1 = 0.37;
                                                    }
                                                } else {
                                                    nb_mimics_model1 = 0.89;
                                                }
                                            } else {
                                                nb_mimics_model1 = 0.89;
                                            }
                                        } else {
                                            nb_mimics_model1 = 0.81;
                                        }
                                    } else {
                                        nb_mimics_model1 = 0.54;
                                    }
                                } else {
                                    if (spmhxvalue == 0) {
                                        if (swellweekb4value == 0) {
                                            nb_mimics_model1 = 0.65;
                                        } else {
                                            if (sfocalweak_value == 0) {
                                                if (smentalstate_value == 0) {
                                                    nb_mimics_model1 = 0.44;
                                                } else {
                                                    nb_mimics_model1 = 0.21;
                                                }
                                            } else {
                                                nb_mimics_model1 = 0.79;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (smedicaltransportvalue == 0) {
                                if (sother_value == 0) {
                                    if (swellweekb4value == 0) {
                                        nb_mimics_model1 = 0.73;
                                    } else {
                                        if (sheadache_value == 0) {
                                            nb_mimics_model1 = 0.73;
                                        } else {
                                            nb_mimics_model1 = 0.92;
                                        }
                                    }
                                }
                            } else {
                                if (spmhxvalue == 0) {
                                    if (sfocalnumb_value == 0) {
                                        if (sseizure_value == 0) {
                                            nb_mimics_model1 = 0.33;
                                        } else {
                                            nb_mimics_model1 = 0.75;
                                        }
                                    } else {
                                        nb_mimics_model1 = 0.53;
                                    }
                                } else {
                                    nb_mimics_model1 = 0.87;
                                }
                            }
                        }

                        /**
                         * Naive Bayes model 1 for classification of ischaemic stroke
                         */
                        if (shighcategory_value == 0) {
                            if (sother_value == 0) {
                                if (sspeechloss_value == 0) {
                                    if (swoke_value == 0) {
                                        nb_ischaemic_model1 = 0.09;
                                    } else {
                                        nb_ischaemic_model1 = 0.19;
                                    }
                                } else {
                                    if (smentalstate_value == 0) {
                                        if (swellweekb4value == 0) {
                                            nb_ischaemic_model1 = 0.86;
                                        } else {
                                            nb_ischaemic_model1 = 0.34;
                                        }
                                    } else {
                                        nb_ischaemic_model1 = 0.67;
                                    }
                                }
                            } else {
                                nb_ischaemic_model1 = 0.02;
                            }
                        } else {
                            if (swellweekb4value == 0) {
                                nb_ischaemic_model1 = 0.23;
                            } else {
                                if (svertigovalue == 0) {
                                    if (svomit_value == 0) {
                                        if (visualdef == 0) {
                                            if (sfocalweak_value == 0) {
                                                nb_ischaemic_model1 = 0.08;
                                            } else {
                                                nb_ischaemic_model1 = 0.74;
                                            }
                                        } else {
                                            nb_ischaemic_model1 = 0.17;
                                        }
                                    } else {
                                        if (sreferred_value == 0) {
                                            if (spmhxvalue == 0) {
                                                nb_ischaemic_model1 = 0.08;
                                            } else {
                                                nb_ischaemic_model1 = 0.2;
                                            }
                                        } else {
                                            nb_ischaemic_model1 = 0.09;
                                        }
                                    }
                                } else {
                                    nb_ischaemic_model1 = 0.59;
                                }
                            }

                            /**
                             * Naive Bayes model 1 for classification of haemorrhagic stroke
                             */
                            if (sseizure_value == 0) {
                                if (ssuddenvalue == 0) {
                                    if (swellweekb4value == 0) {
                                        nb_haemorrhagic_model1 = 0.04;
                                    } else {
                                        if (sfocalnumb_value == 0) {
                                            if (spmhxvalue == 0) {
                                                nb_haemorrhagic_model1 = 0.07;
                                            } else {
                                                nb_haemorrhagic_model1 = 0.2;
                                            }
                                        } else {
                                            nb_haemorrhagic_model1 = 0.09;
                                        }
                                    }
                                } else {
                                    if (sreferred_value == 0) {
                                        if (svomit_value == 0) {
                                            if (sdizziness_value == 0) {
                                                if (shighcategory_value == 0) {
                                                    nb_haemorrhagic_model1 = 0.03;
                                                } else {
                                                    nb_haemorrhagic_model1 = 0.22;
                                                }
                                            } else {
                                                nb_haemorrhagic_model1 = 0.11;
                                            }
                                        } else {
                                            if (smedicaltransportvalue == 0) {
                                                if (shighcategory_value == 0) {
                                                    nb_haemorrhagic_model1 = 0.04;
                                                } else {
                                                    nb_haemorrhagic_model1 = 0.33;
                                                }
                                            } else {
                                                nb_haemorrhagic_model1 = 0.31;
                                            }
                                        }
                                    } else {
                                        if (smentalstate_value == 0) {
                                            if (sdizziness_value == 0) {
                                                if (shighcategory_value == 0) {
                                                    if (spmhxvalue == 0) {
                                                        if (swellweekb4value == 0) {
                                                            nb_haemorrhagic_model1 = 0.09;
                                                        } else {
                                                            nb_haemorrhagic_model1 = 0.16;
                                                        }
                                                    } else {
                                                        nb_haemorrhagic_model1 = 0.11;
                                                    }
                                                } else {
                                                    nb_haemorrhagic_model1 = 0.31;
                                                }
                                            } else {
                                                nb_haemorrhagic_model1 = 0.15;
                                            }
                                        } else {
                                            nb_haemorrhagic_model1 = 0.29;
                                        }
                                    }
                                }
                            } else {
                                if (smedicaltransportvalue == 0) {
                                    nb_haemorrhagic_model1 = 0.12;
                                } else {
                                    if (swoke_value == 0) {
                                        if (sother_value == 0) {
                                            if (shighcategory_value == 0) {
                                                nb_haemorrhagic_model1 = 0.09;
                                            } else {
                                                nb_haemorrhagic_model1 = 0.36;
                                            }
                                        } else {
                                            nb_haemorrhagic_model1 = 0.22;
                                        }
                                    } else {
                                        nb_haemorrhagic_model1 = 0.18;
                                    }
                                }
                            }

                            /**
                             * Naive Bayes model 2 for classification of stroke mimics
                             */
                            if (shighcategory_value == 0) {
                                if (gsensepos == 0) {
                                    if (swellweekb4value == 0) {
                                        if (ssuddenvalue == 0) {
                                            nb_mimics_model2 = 0.84;
                                        } else {
                                            if (gotherpos == 0) {
                                                nb_mimics_model2 = 0.8;
                                            } else {
                                                nb_mimics_model2 = 0.79;
                                            }
                                        }
                                    } else {
                                        if (gsignpos == 0) {
                                            nb_mimics_model2 = 0.89;
                                        } else {
                                            if (sgendervalue == 0) {
                                                if (spmhxvalue == 0) {
                                                    nb_mimics_model2 = 0.77;
                                                } else {
                                                    nb_mimics_model2 = 0.58;
                                                }
                                            } else {
                                                if (ssuddenvalue == 0) {
                                                    nb_mimics_model2 = 0.83;
                                                } else {
                                                    if (swoke_value == 0) {
                                                        nb_mimics_model2 = 0.53;
                                                    } else {
                                                        nb_mimics_model2 = 0.18;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (swoke_value == 0) {
                                        if (sgendervalue == 0) {
                                            nb_mimics_model2 = 0.8;
                                        } else {
                                            nb_mimics_model2 = 0.88;
                                        }
                                    } else {
                                        nb_mimics_model2 = 0.6;
                                    }
                                }
                            } else {
                                if (spmhxvalue == 0) {
                                    if (swellweekb4value == 0) {
                                        nb_mimics_model2 = 0.47;
                                    } else {
                                        if (sreferred_value == 0) {
                                            if (swoke_value == 0) {
                                                if (lowgcs == 0) {
                                                    nb_mimics_model2 = 0.08;
                                                } else {
                                                    nb_mimics_model2 = 0.5;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (swoke_value == 0) {
                                        if (sreferred_value == 0) {
                                            nb_mimics_model2 = 0.83;
                                        } else {
                                            nb_mimics_model2 = 0.27;
                                        }
                                    } else {
                                        nb_mimics_model2 = 0.62;
                                    }
                                }
                            }

                            /**
                             * Naive Bayes model 2 for classification of ischaemic stroke
                             */
                            if (spmhxvalue == 0) {
                                if (sreferred_value == 0) {
                                    if (shighcategory_value == 0) {
                                        if (smedicaltransportvalue == 0) {
                                            if (sgendervalue == 0) {
                                                nb_ischaemic_model2 = 0.03;
                                            } else {
                                                if (gsensepos == 0) {
                                                    if (swellweekb4value == 0) {
                                                        nb_ischaemic_model2 = 0.08;
                                                    } else {
                                                        nb_ischaemic_model2 = 0.21;
                                                    }
                                                } else {
                                                    nb_ischaemic_model2 = 0.14;
                                                }
                                            }
                                        }
                                    } else {
                                        if (gsensepos == 0) {
                                            if (smedicaltransportvalue == 0) {
                                                nb_ischaemic_model2 = 0.27;
                                            } else {
                                                if (group_abngcs == 0) {
                                                    nb_ischaemic_model2 = 0.56;
                                                } else {
                                                    nb_ischaemic_model2 = 0.12;
                                                }
                                            }
                                        } else {
                                            nb_ischaemic_model2 = 0.4;
                                        }
                                    }
                                }
                            } else {
                                if (shighcategory_value == 0) {
                                    if (gspeechpos == 0) {
                                        if (gmotorpos == 0) {
                                            nb_ischaemic_model2 = 0.07;
                                        } else {
                                            nb_ischaemic_model2 = 0.28;
                                        }
                                    } else {
                                        nb_ischaemic_model2 = 0.46;
                                    }
                                } else {
                                    if (swellweekb4value == 0) {
                                        nb_ischaemic_model2 = 0.15;
                                    } else {
                                        if (gsignpos == 0) {
                                            nb_ischaemic_model2 = 0.2;
                                        } else {
                                            nb_ischaemic_model2 = 0.29;
                                        }
                                    }
                                }
                            }

                            /**
                             * Naive Bayes model 2 for classification of haemorrhagic stroke
                             */
                            if (ssuddenvalue == 0) {
                                nb_haemorrhagic_model2 = 0.05;
                            } else {
                                if (sgendervalue == 0) {
                                    if (group_abngcs == 0) {
                                        if (spmhxvalue == 0) {
                                            if (swellweekb4value == 0) {
                                                nb_haemorrhagic_model2 = 0;
                                            } else {
                                                if (smedicaltransportvalue == 0) {
                                                    nb_haemorrhagic_model2 = 0.09;
                                                } else {
                                                    nb_haemorrhagic_model2 = 0.2;
                                                }
                                            }
                                        } else {
                                            nb_haemorrhagic_model2 = 0.03;
                                        }
                                    } else {
                                        if (swoke_value == 0) {
                                            if (sreferred_value == 0) {
                                                if (spmhxvalue == 0) {
                                                    nb_haemorrhagic_model2 = 0.46;
                                                } else {
                                                    nb_haemorrhagic_model2 = 0.09;
                                                }
                                            } else {
                                                nb_haemorrhagic_model2 = 0.09;
                                            }
                                        } else {
                                            nb_haemorrhagic_model2 = 0.2;
                                        }
                                    }
                                } else {
                                    if (group_abngcs == 0) {
                                        nb_haemorrhagic_model2 = 0.08;
                                    } else {
                                        if (smedicaltransportvalue == 0) {
                                            nb_haemorrhagic_model2 = 0.4;
                                        } else {
                                            nb_haemorrhagic_model2 = 0.42;
                                        }
                                    }
                                }
                            }

                            /**
                             * Naive Bayes model 3 for classification of stroke mimics
                             */
                            if (sweakhand_value == 0) {
                                if (sother2_value == 0) {
                                    if (visualdef == 0) {
                                        if (eyemovement == 0) {
                                            if (ssensearm_value == 0) {
                                                if (sother_value == 0) {
                                                    if (sloc_value == 0) {
                                                        if (ataxia1 == 0) {
                                                            if (smentalstate_value == 0) {
                                                                if (svision_value == 0) {
                                                                    if (sfocalweak_value == 0) {
                                                                        if (sheadache_value == 0) {
                                                                            nb_mimics_model3 = 0.82;
                                                                        } else {
                                                                            nb_mimics_model3 = 0.78;
                                                                        }
                                                                    } else {
                                                                        nb_mimics_model3 = 0.89;
                                                                    }
                                                                } else {
                                                                    nb_mimics_model3 = 0.88;
                                                                }
                                                            } else {
                                                                nb_mimics_model3 = 0.45;
                                                            }
                                                        } else {
                                                            nb_mimics_model3 = 0.9;
                                                        }
                                                    } else {
                                                        if (smentalstate_value == 0) {
                                                            nb_mimics_model3 = 0.69;
                                                        } else {
                                                            nb_mimics_model3 = 0.61;
                                                        }
                                                    }
                                                } else {
                                                    nb_mimics_model3 = 0.93;
                                                }
                                            } else {
                                                nb_mimics_model3 = 0.91;
                                            }
                                        } else {
                                            nb_mimics_model3 = 0.72;
                                        }
                                    } else {
                                        if (ataxia1 == 0) {
                                            nb_mimics_model3 = 0.75;
                                        } else {
                                            nb_mimics_model3 = 0.83;
                                        }
                                    }
                                } else {
                                    if (sheadache_value == 0) {
                                        nb_mimics_model3 = 0.89;
                                    } else {
                                        nb_mimics_model3 = 0.69;
                                    }
                                }
                            } else {
                                if (ataxia1 == 0) {
                                    if (svertigovalue == 0) {
                                        if (sseizure_value == 0) {
                                            if (ataxia1 == 0) {
                                                if (swalknotokcrf2_value == 0) {
                                                    if (ssenseface_value == 0) {
                                                        if (smentalstate_value == 0) {
                                                            nb_mimics_model3 = 0.54;
                                                        } else {
                                                            nb_mimics_model3 = 0.24;
                                                        }
                                                    } else {
                                                        nb_mimics_model3 = 0.56;
                                                    }
                                                } else {
                                                    nb_mimics_model3 = 0.05;
                                                }
                                            } else {
                                                nb_mimics_model3 = 0.14;
                                            }
                                        } else {
                                            nb_mimics_model3 = 0.3;
                                        }
                                    } else {
                                        nb_mimics_model3 = 0.74;
                                    }
                                } else {
                                    nb_mimics_model3 = 0.56;
                                }

                                /**
                                 * Naive Bayes model 3 for classification of ischaemic stroke
                                 */
                                if (weakleg == 0) {
                                    if (sother_value == 0) {
                                        if (visualdef == 0) {
                                            if (weakarm == 0) {
                                                if (svision_value == 0) {
                                                    if (ssenseleg_value == 0) {
                                                        if (sloc_value == 0) {
                                                            if (dysphasia_symptom == 0) {
                                                                if (sheadache_value == 0) {
                                                                    nb_ischaemic_model3 = 0.09;
                                                                } else {
                                                                    if (swalknotokcrf2_value == 0) {
                                                                        if (sfocalnumb_value == 0) {
                                                                            if (sseizure_value == 0) {
                                                                                nb_ischaemic_model3 = 0.13;
                                                                            } else {
                                                                                nb_ischaemic_model3 = 0.25;
                                                                            }
                                                                        } else {
                                                                            nb_ischaemic_model3 = 0.08;
                                                                        }
                                                                    } else {
                                                                        nb_ischaemic_model3 = 0.25;
                                                                    }
                                                                }
                                                            } else {
                                                                nb_ischaemic_model3 = 0.74;
                                                            }
                                                        } else {
                                                            nb_ischaemic_model3 = 0.03;
                                                        }
                                                    } else {
                                                        nb_ischaemic_model3 = 0.25;
                                                    }
                                                } else {
                                                    nb_ischaemic_model3 = 0.13;
                                                }
                                            } else {
                                                nb_ischaemic_model3 = 0.34;
                                            }
                                        } else {
                                            nb_ischaemic_model3 = 0.11;
                                        }
                                    } else {
                                        nb_ischaemic_model3 = 0.02;
                                    }
                                } else {
                                    if (sweakhand_value == 0) {
                                        nb_ischaemic_model3 = 0.1;
                                    } else {
                                        if (ataxia1 == 0) {
                                            if (ssenseneg_value == 0) {
                                                nb_ischaemic_model3 = 0.63;
                                            } else {
                                                nb_ischaemic_model3 = 0.66;
                                            }
                                        } else {
                                            nb_ischaemic_model3 = 0.3;
                                        }
                                    }
                                }

                                /**
                                 * Naive Bayes model 3 for classification of haemorrhagic stroke
                                 */
                                if (sfocalweak_value == 0) {
                                    if (weakleg == 0) {
                                        if (sseizure_value == 0) {
                                            if (ssenseleg_value == 0) {
                                                if (eyemovement == 0) {
                                                    if (sspeechloss_value == 0) {
                                                        if (sother2_value == 0) {
                                                            if (weakarm == 0) {
                                                                if (sfocalnumb_value == 0) {
                                                                    if (visualdef == 0) {
                                                                        if (ataxia1 == 0) {
                                                                            if (svomit_value == 0) {
                                                                                nb_haemorrhagic_model3 = 0.19;
                                                                            } else {
                                                                                if (sother_value == 0) {
                                                                                    if (svision_value == 0) {
                                                                                        nb_haemorrhagic_model3 = 0.39;
                                                                                    } else {
                                                                                        nb_haemorrhagic_model3 = 0.27;
                                                                                    }
                                                                                } else {
                                                                                    nb_haemorrhagic_model3 = 0.18;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            nb_haemorrhagic_model3 = 0.11;
                                                                        }
                                                                    } else {
                                                                        nb_haemorrhagic_model3 = 0.26;
                                                                    }
                                                                } else {
                                                                    nb_haemorrhagic_model3 = 0.08;
                                                                }
                                                            } else {
                                                                nb_haemorrhagic_model3 = 0.26;
                                                            }
                                                        } else {
                                                            nb_haemorrhagic_model3 = 0.12;
                                                        }
                                                    } else {
                                                        nb_haemorrhagic_model3 = 0.12;
                                                    }
                                                } else {
                                                    nb_haemorrhagic_model3 = 0.13;
                                                }
                                            } else {
                                                nb_haemorrhagic_model3 = 0.15;
                                            }
                                        } else {
                                            nb_haemorrhagic_model3 = 0.15;
                                        }
                                    } else {
                                        nb_haemorrhagic_model3 = 0.17;
                                    }
                                } else {
                                    if (eyemovement == 0) {
                                        if (dysaphsia_symptom == 0) {
                                            if (smentalstate_value == 0) {
                                                nb_haemorrhagic_model3 = 0.01;
                                            } else {
                                                nb_haemorrhagic_model3 = 0.37;
                                            }
                                        } else {
                                            if (svomit_value == 0) {
                                                nb_haemorrhagic_model3 = 0.04;
                                            } else {
                                                nb_haemorrhagic_model3 = 0.25;
                                            }
                                        }
                                    } else {
                                        nb_haemorrhagic_model3 = 0.16;
                                    }
                                }

                                /**
                                 * Naive Bayes model for classification of stroke mimics
                                 */
                                if (sloc_value == 0) {
                                    if (sother_value == 0) {
                                        if (sspeechloss_value == 0) {
                                            if (gsensepos == 0) {
                                                if (gsignpos == 0) {
                                                    if (sheadache_value == 0) {
                                                        nb_mimics_model4 = 0.83;
                                                    } else {
                                                        if (ataxia1 == 0) {
                                                            if (svision_value == 0) {
                                                                if (sseizure_value == 0) {
                                                                    nb_mimics_model4 = 0.71;
                                                                } else {
                                                                    nb_mimics_model4 = 0.86;
                                                                }
                                                            } else {
                                                                nb_mimics_model4 = 0.83;
                                                            }
                                                        } else {
                                                            nb_mimics_model4 = 0.71;
                                                        }
                                                    }
                                                } else {
                                                    if (sheadache_value == 0) {
                                                        if (smentalstate_value == 0) {
                                                            if (gmotorpos == 0) {
                                                                nb_mimics_model4 = 0.94;
                                                            } else {
                                                                if (sseizure_value == 0) {
                                                                    nb_mimics_model4 = 0.65;
                                                                } else {
                                                                    nb_mimics_model4 = 0.86;
                                                                }
                                                            }
                                                        } else {
                                                            nb_mimics_model4 = 0.32;
                                                        }
                                                    } else {
                                                        if (gotherpos == 0) {
                                                            nb_mimics_model4 = 0.65;
                                                        } else {
                                                            nb_mimics_model4 = 0.6;
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (svision_value == 0) {
                                                    nb_mimics_model4 = 0.74;
                                                } else {
                                                    nb_mimics_model4 = 0.85;
                                                }
                                            }
                                        } else {
                                            if (svomit_value == 0) {
                                                if (group_abngcs == 0) {
                                                    if (sfocalweak_value == 0) {
                                                        nb_mimics_model4 = 0.75;
                                                    } else {
                                                        nb_mimics_model4 = 0.29;
                                                    }
                                                } else {
                                                    nb_mimics_model4 = 0.37;
                                                }
                                            } else {
                                                nb_mimics_model4 = 0.65;
                                            }
                                        }
                                    } else {
                                        if (svomit_value == 0) {
                                            if (sheadache_value == 0) {
                                                nb_mimics_model4 = 0.91;
                                            } else {
                                                nb_mimics_model4 = 0.93;
                                            }
                                        } else {
                                            nb_mimics_model4 = 0.85;
                                        }
                                    }
                                } else {
                                    if (sheadache_value == 0) {
                                        nb_mimics_model4 = 0.67;
                                    } else {
                                        nb_mimics_model4 = 0.561;
                                    }
                                }

                                /**
                                 * Naive Bayes model 4 for classification of ischaemic stroke
                                 */
                                if (gsignpos == 0) {
                                    if (svomit_value == 0) {
                                        if (sheadache_value == 0) {
                                            nb_ischaemic_model4 = 0.07;
                                        } else {
                                            nb_ischaemic_model4 = 0.03;
                                        }
                                    } else {
                                        nb_ischaemic_model4 = 0.03;
                                    }
                                } else {
                                    if (group_abngcs == 0) {
                                        if (ataxia1 == 0) {
                                            if (sdizziness_value == 0) {
                                                if (sother_value == 0) {
                                                    if (gsensepos == 0) {
                                                        if (svision_value == 0) {
                                                            if (gotherpos == 0) {
                                                                if (sfocalnumb_value == 0) {
                                                                    if (sspeechloss_value == 0) {
                                                                        nb_ischaemic_model4 = 0;
                                                                    } else {
                                                                        nb_ischaemic_model4 = 0.71;
                                                                    }
                                                                } else {
                                                                    nb_ischaemic_model4 = 0.59;
                                                                }
                                                            } else {
                                                                nb_ischaemic_model4 = 0.5;
                                                            }
                                                        } else {
                                                            nb_ischaemic_model4 = 0.13;
                                                        }
                                                    } else {
                                                        nb_ischaemic_model4 = 0.3;
                                                    }
                                                } else {
                                                    nb_ischaemic_model4 = 0.04;
                                                }
                                            } else {
                                                nb_ischaemic_model4 = 0.26;
                                            }
                                        } else {
                                            if (svomit_value == 0) {
                                                nb_ischaemic_model4 = 0.21;
                                            } else {
                                                nb_ischaemic_model4 = 0.2;
                                            }
                                        }
                                    } else {
                                        if (svision_value == 0) {
                                            if (sseizure_value == 0) {
                                                if (gotherpos == 0) {
                                                    nb_ischaemic_model4 = 0.39;
                                                } else {
                                                    nb_ischaemic_model4 = 0.19;
                                                }
                                            } else {
                                                nb_ischaemic_model4 = 0.26;
                                            }
                                        } else {
                                            nb_ischaemic_model4 = 0.27;
                                        }
                                    }
                                }

                                /**
                                 * Naive Bayes model 4 for classification of haemorrhagic stroke
                                 */
                                if (sseizure_value == 0) {
                                    if (gsensepos == 0) {
                                        if (sfocalweak_value == 0) {
                                            if (gotherpos == 0) {
                                                if (svertigovalue == 0) {
                                                    if (sfocalnumb_value == 0) {
                                                        if (sspeechloss_value == 0) {
                                                            if (gmotorpos == 0) {
                                                                if (sloc_value == 0) {
                                                                    if (svision_value == 0) {
                                                                        if (sother_value == 0) {
                                                                            nb_haemorrhagic_model4 = 0.33;
                                                                        } else {
                                                                            nb_haemorrhagic_model4 = 0.14;
                                                                        }
                                                                    } else {
                                                                        nb_haemorrhagic_model4 = 0.09;
                                                                    }
                                                                } else {
                                                                    nb_haemorrhagic_model4 = 0.46;
                                                                }
                                                            } else {
                                                                nb_haemorrhagic_model4 = 0.14;
                                                            }
                                                        } else {
                                                            nb_haemorrhagic_model4 = 0.25;
                                                        }
                                                    } else {
                                                        nb_haemorrhagic_model4 = 0.07;
                                                    }
                                                } else {
                                                    nb_haemorrhagic_model4 = 0.14;
                                                }
                                            } else {
                                                if (smentalstate_value == 0) {
                                                    if (sheadache_value == 0) {
                                                        nb_haemorrhagic_model4 = 0.06;
                                                    } else {
                                                        nb_haemorrhagic_model4 = 0.23;
                                                    }
                                                } else {
                                                    nb_haemorrhagic_model4 = 0.25;
                                                }
                                            }
                                        } else {
                                            if (sspeechloss_value == 0) {
                                                if (sother_value == 0) {
                                                    if (sfocalnumb_value == 0) {
                                                        if (sheadache_value == 0) {
                                                            nb_haemorrhagic_model4 = 0.06;
                                                        } else {
                                                            nb_haemorrhagic_model4 = 0.26;
                                                        }
                                                    } else {
                                                        nb_haemorrhagic_model4 = 0.18;
                                                    }
                                                } else {
                                                    nb_haemorrhagic_model4 = 0.14;
                                                }
                                            } else {
                                                nb_haemorrhagic_model4 = 0.05;
                                            }
                                        }
                                    } else {
                                        if (svomit_value == 0) {
                                            nb_haemorrhagic_model4 = 0.04;
                                        } else {
                                            nb_haemorrhagic_model4 = 0.08;
                                        }
                                    }
                                } else {
                                    if (sheadache_value == 0) {
                                        if (sfocalweak_value == 0) {
                                            nb_haemorrhagic_model4 = 0.13;
                                        } else {
                                            nb_haemorrhagic_model4 = 0.13;
                                        }
                                    } else {
                                        nb_haemorrhagic_model4 = 0.2;
                                    }
                                }

                                /**
                                 * Naive Bayes model 5 for classification of stroke mimics
                                 */
                                if (gmotorpos == 0) {
                                    if (gspeechpos == 0) {
                                        nb_mimics_model5 = 0.8;
                                    } else {
                                        nb_mimics_model5 = 0.54;
                                    }
                                } else {
                                    if (gsignpos == 0) {
                                        nb_mimics_model5 = 0.88;
                                    } else {
                                        if (weakleg == 0) {
                                            if (gspeechpos == 0) {
                                                if (weakarm == 0) {
                                                    nb_mimics_model5 = 0.91;
                                                } else {
                                                    nb_mimics_model5 = 0.65;
                                                }
                                            } else {
                                                if (dysaphsia_symptom == 0) {
                                                    if (weakarm == 0) {
                                                        nb_mimics_model5 = 0.94;
                                                    } else {
                                                        if (weakface == 0) {
                                                            nb_mimics_model5 = 0.74;
                                                        } else {
                                                            nb_mimics_model5 = .21;
                                                        }
                                                    }
                                                } else {
                                                    nb_mimics_model5 = 0.22;
                                                }
                                            }
                                        }
                                    }
                                }

                                /**
                                 * Naive Bayes model for classification of ischaemic stroke
                                 */
                                if (gmotorpos == 0) {
                                    if (gsignpos == 0) {
                                        nb_ischaemic_model5 = 0.02;
                                    } else {
                                        if (dysaphsia_symptom == 0) {
                                            nb_mimics_model5 = 0.03;
                                        } else {
                                            nb_mimics_model5 = 0.3;
                                        }
                                    }
                                } else {
                                    if (weakarm == 0) {
                                        if (weakface == 0) {
                                            nb_mimics_model5 = 0.03;
                                        } else {
                                            if (dysaphsia_symptom == 0) {
                                                nb_mimics_model5 = 0.09;
                                            } else {
                                                nb_mimics_model5 = 0.54;
                                            }
                                        }
                                    } else {
                                        if (gspeechpos == 0) {
                                            if (weakleg == 0) {
                                                nb_mimics_model5 = 0.28;
                                            } else {
                                                if (sweakhand_value == 0) {
                                                    nb_mimics_model5 = 0.23;
                                                } else {
                                                    if (weakface == 0) {
                                                        nb_mimics_model5 = 0.29;
                                                    } else {
                                                        nb_mimics_model5 = 0.72;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (weakface == 0) {
                                                nb_mimics_model5 = 0.25;
                                            } else {
                                                nb_mimics_model5 = 0.77;
                                            }
                                        }
                                    }
                                }

                                /**
                                 * Naive Bayes model 5 for classification of haemorrhagic stroke - N/A
                                 */

                                /**
                                 * Naive Bayes model 6 for classification of stroke mimics
                                 */
                                if (weakarm == 0) {
                                    if (gspeechpos == 0) {
                                        if (svertigovalue == 0) {
                                            if (lowgcs == 0) {
                                                nb_mimics_model6 = 0.87;
                                            } else {
                                                nb_mimics_model6 = 0.32;
                                            }
                                        } else {
                                            nb_mimics_model6 = 0.89;
                                        }
                                    } else {
                                        nb_mimics_model6 = 0.62;
                                    }
                                } else {
                                    if (svertigovalue == 0) {
                                        if (dysaphsia_symptom == 0) {
                                            if (ssenseneg_value == 0) {
                                                if (sweakhand_value == 0) {
                                                    nb_mimics_model6 = 0.76;
                                                } else {
                                                    if (lowgcs == 0) {
                                                        if (weakleg == 0) {
                                                            nb_mimics_model6 = 0.64;
                                                        } else {
                                                            if (weakface == 0) {
                                                                nb_mimics_model6 = 0.66;
                                                            } else {
                                                                nb_mimics_model6 = 0.22;
                                                            }
                                                        }
                                                    } else {
                                                        nb_mimics_model6 = 0.25;
                                                    }
                                                }
                                            } else {
                                                nb_mimics_model6 = 0.25;
                                            }
                                        } else {
                                            nb_mimics_model6 = 0.17;
                                        }
                                    } else {
                                        nb_mimics_model6 = 0.78;
                                    }
                                }

                                /**
                                 * Naive bayes model 6 for classification of haemorrhagic stroke
                                 */
                                if (gspeechpos == 0) {
                                    if (sweakhand_value == 0) {
                                        if (svertigovalue == 0) {
                                            if (weakarm == 0) {
                                                if (lowgcs == 0) {
                                                    nb_haemorrhagic_model6 = 0.09;
                                                } else {
                                                    nb_haemorrhagic_model6 = 0.68;
                                                }
                                            } else {
                                                nb_haemorrhagic_model6 = 0.06;
                                            }
                                        } else {
                                            nb_haemorrhagic_model6 = 0.11;
                                        }
                                    } else {
                                        if (svertigovalue == 0) {
                                            if (weakleg == 0) {
                                                nb_haemorrhagic_model6 = 0.16;
                                            } else {
                                                if (weakarm == 0) {
                                                    nb_haemorrhagic_model6 = 0.25;
                                                } else {
                                                    nb_haemorrhagic_model6 = 0.12;
                                                }
                                            }
                                        } else {
                                            nb_haemorrhagic_model6 = 0.25;
                                        }
                                    }
                                } else {
                                    if (svertigovalue == 0) {
                                        if (sweakhand_value == 0) {
                                            nb_haemorrhagic_model6 = 0.13;
                                        } else {
                                            nb_haemorrhagic_model6 = 0.13;
                                        }
                                    } else {
                                        nb_haemorrhagic_model6 = 0.2;
                                    }
                                }

                                /**
                                 * Naive Bayes model for classification of ischaemic stroke
                                 */
                                if (sweakhand_value == 0) {
                                    if (dysphasia_symptom == 0) {
                                        if (gspeechpos == 0) {
                                            if (svertigovalue == 0) {
                                                if (lowgcs == 0) {
                                                    if (weakarm == 0) {
                                                        nb_ischaemic_mode6 = 0.04;
                                                    } else {
                                                        nb_ischaemic_mode6 = 0.28;
                                                    }
                                                } else {
                                                    nb_ischaemic_mode6 = 0.05;
                                                }
                                            } else {
                                                nb_ischaemic_mode6 = 0.11;
                                            }
                                        } else {
                                            nb_ischaemic_mode6 = 0.28;
                                        }
                                    } else {
                                        nb_ischaemic_mode6 = 0.33;
                                    }
                                } else {
                                    if (svertigovalue == 0) {
                                        if (weakleg == 0) {
                                            nb_ischaemic_mode6 = 0.33;
                                        } else {
                                            if (ssenseneg_value == 0) {
                                                if (dysaphsia_symptom == 0) {
                                                    if (weakarm == 0) {
                                                        nb_ischaemic_mode6 = 0.25;
                                                    } else {
                                                        if (lowgcs == 0) {
                                                            if (weakface == 0) {
                                                                nb_ischaemic_mode6 = 0.29;
                                                            } else {
                                                                nb_ischaemic_mode6 = 0.74;
                                                            }
                                                        } else {
                                                            nb_ischaemic_mode6 = 0.23;
                                                        }
                                                    }
                                                } else {
                                                    nb_ischaemic_mode6 = 0.77;
                                                }
                                            } else {
                                                nb_ischaemic_mode6 = 0.71;
                                            }
                                        }
                                    } else {
                                        nb_ischaemic_mode6 = 0.21;
                                    }
                                }

                                /**
                                 * ensemble model for classification of stroke mimics
                                 */
                                if (nb_mimics_model6 < 0.47) {
                                    if (nb_mimics_model3 < 0.49) {
                                        buckets_mimics_cart = 0;
                                    } else {
                                        if (cart_haemorrhagic_model1 >= 0.025) {
                                            buckets_mimics_cart = 0.17;
                                        } else {
                                            buckets_mimics_cart = 0.78;
                                        }
                                    }
                                } else {
                                    if (nb_ischaemic_model1 >= 0.46) {
                                        buckets_mimics_cart = 0.18;
                                    } else {
                                        if (nb_mimics_model4 < 0.84) {
                                            if (cart_haemorrhagic_model2 >= 0.04) {
                                                if (nb_mimics_model2 < 0.57) {
                                                    buckets_mimics_cart = 0.23;
                                                } else {
                                                    buckets_mimics_cart = 0.74;
                                                }
                                            } else {
                                                buckets_mimics_cart = 0.91;
                                            }
                                        } else {
                                            buckets_mimics_cart = 0.98;
                                        }
                                    }
                                }

                                /*
                                 * ensemble model for classificatio of ischaemic stroke
                                 */
                                if (cart_ischaemic_model3 < 0.28) {
                                    if (nb_ischaemic_model1 < 0.5) {
                                        buckets_ischaemic_cart = 0.05;
                                    } else {
                                        buckets_ischaemic_cart = 0.67;
                                    }
                                } else {
                                    if (nb_ischaemic_model4 < 0.2) {
                                        buckets_ischaemic_cart = 0.12;
                                    } else {
                                        if (nb_mimics_model2 > 0.48) {
                                            if (cart_ischaemic_model2 < 0.58) {
                                                if (nb_mimics_model6 >= 0.23) {
                                                    buckets_ischaemic_cart = 0.29;
                                                } else {
                                                    buckets_ischaemic_cart = 0.81;
                                                }
                                            } else {
                                                buckets_ischaemic_cart = 1;
                                            }
                                        } else {
                                            buckets_ischaemic_cart = 1;
                                        }
                                    }
                                }

                                /*
                                 * ensemble model for classification of haemorrhagic stroke
                                 */
                                if (cart_haemorrhagic_model2 < 0.04) {
                                    buckets_haemorrhagic_cart = 0.01;
                                } else {
                                    if (nb_haemorrhagic_model4 < 0.22) {
                                        buckets_haemorrhagic_cart = 0.11;
                                    } else {
                                        if (nb_mimics_model2 >= 0.44) {
                                            buckets_ischaemic_cart = 0.36;
                                        } else {
                                            buckets_ischaemic_cart = 1;
                                        }
                                    }
                                }

                                /*
                                 * ensemble model for classification of stroke mimics
                                 */
                                if (nb_mimics_model6 < 0.47) {
                                    if (nb_mimics_model3 < 0.49) {
                                        stacking_mimics_cart = 0;
                                    } else {
                                        if (nb_mimics_model2 < 0.64) {
                                            stacking_mimics_cart = 0.16;
                                        } else {
                                            stacking_mimics_cart = 0.62;
                                        }
                                    }
                                } else {
                                    if (nb_mimics_model4 < 0.84) {
                                        if (nb_mimics_model3 < 0.49) {
                                            stacking_mimics_cart = 0.33;
                                        } else {
                                            if (cart_mimics_model1 >= 0.27) {
                                                if (nb_mimics_model2 < 0.55) {
                                                    stacking_mimics_cart = 0.38;
                                                } else {
                                                    stacking_mimics_cart = 0.76;
                                                }
                                            } else {
                                                stacking_mimics_cart = 0.9;
                                            }
                                        }
                                    } else {
                                        stacking_mimics_cart = 0.98;
                                    }
                                }

                                /*
                                 * CART ensemble model for classification of ischaemic stroke
                                 */
                                if (cart_ischaemic_model3 < 0.28) {
                                    if (nb_ischaemic_model1 < 0.5) {
                                        stacking_ischaemic_cart = 0.05;
                                    } else {
                                        stacking_ischaemic_cart = 0.67;
                                    }
                                } else {
                                    if (nb_ischaemic_model4 < 0.2) {
                                        stacking_ischaemic_cart = 0.12;
                                    } else {
                                        stacking_ischaemic_cart = 0.82;
                                    }
                                }

                                /*
                                 *  Statcking CART ensemble model for classification of haemorrhagic stroke
                                 */
                                if (cart_haemorrhagic_model2 < 0.04) {
                                    stacking_haemorrhagic_cart = 0.01;
                                } else {
                                    if (nb_haemorrhagic_model4 < 0.22) {
                                        stacking_haemorrhagic_cart = 0.11;
                                    } else {
                                        if (nb_haemorrhagic_model2 < 0.3) {
                                            stacking_haemorrhagic_cart = 0.47;
                                        } else {
                                            stacking_haemorrhagic_cart = 1;
                                        }
                                    }
                                }

                                /*
                                 * Bucket NB ensemble model for classification of stroke mimics
                                 */
                                if (nb_mimics_model4 == 0.29) {
                                    buckets_mimics_nb = 0.29;
                                } else {
                                    if (nb_mimics_model4 == 0.32) {
                                        buckets_mimics_nb = 0.3;
                                    } else {
                                        if (nb_mimics_model4 == 0.37) {
                                            buckets_mimics_nb = 0.33;
                                        } else {
                                            if (nb_mimics_model4 == 0.6) {
                                                buckets_mimics_nb = 0.61;
                                            } else {
                                                if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.19) {
                                                    buckets_mimics_nb = 0.76;
                                                } else {
                                                    if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.25) {
                                                        buckets_mimics_nb = 0.5;
                                                    } else {
                                                        if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.29) {
                                                            buckets_mimics_nb = 0.28;
                                                        } else {
                                                            if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.59) {
                                                                buckets_mimics_nb = 0.95;
                                                            } else {
                                                                if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.84) {
                                                                    buckets_mimics_nb = 0.5;
                                                                } else {
                                                                    if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 0.93) {
                                                                        buckets_mimics_nb = 0.5;
                                                                    } else {
                                                                        if (nb_mimics_model4 == 0.66 && cart_mimics_model3 == 1) {
                                                                            buckets_mimics_nb = 0.5;
                                                                        } else {
                                                                            if (nb_mimics_model4 == 0.67) {
                                                                                buckets_mimics_nb = 0.67;
                                                                            } else {
                                                                                if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.05) {
                                                                                    buckets_mimics_nb = 0.5;
                                                                                } else {
                                                                                    if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.14) {
                                                                                        buckets_mimics_nb = 0.5;
                                                                                    } else {
                                                                                        if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.24) {
                                                                                            buckets_mimics_nb = 0.5;
                                                                                        } else {
                                                                                            if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.3) {
                                                                                                buckets_mimics_nb = 0.5;
                                                                                            } else {
                                                                                                if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.45) {
                                                                                                    buckets_mimics_nb = 0.25;
                                                                                                } else {
                                                                                                    if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.54) {
                                                                                                        buckets_mimics_nb = 0.5;
                                                                                                    } else {
                                                                                                        if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.56) {
                                                                                                            buckets_mimics_nb = 0.5;
                                                                                                        } else {
                                                                                                            if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.61) {
                                                                                                                buckets_mimics_nb = 0.5;
                                                                                                            } else {
                                                                                                                if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.69) {
                                                                                                                    buckets_mimics_nb = 0.5;
                                                                                                                } else {
                                                                                                                    if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.72) {
                                                                                                                        buckets_mimics_nb = 0.5;
                                                                                                                    } else {
                                                                                                                        if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.74) {
                                                                                                                            buckets_mimics_nb = 0.5;
                                                                                                                        } else {
                                                                                                                            if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.75) {
                                                                                                                                buckets_mimics_nb = 0.5;
                                                                                                                            } else {
                                                                                                                                if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.78) {
                                                                                                                                    buckets_mimics_nb = 0.77;
                                                                                                                                } else {
                                                                                                                                    if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.82) {
                                                                                                                                        buckets_mimics_nb = 0.5;
                                                                                                                                    } else {
                                                                                                                                        if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.83) {
                                                                                                                                            buckets_mimics_nb = 0.5;
                                                                                                                                        } else {
                                                                                                                                            if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.88) {
                                                                                                                                                buckets_mimics_nb = 0.5;
                                                                                                                                            } else {
                                                                                                                                                if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.89) {
                                                                                                                                                    buckets_mimics_nb = 0.5;
                                                                                                                                                } else {
                                                                                                                                                    if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.9) {
                                                                                                                                                        buckets_mimics_nb = 0.71;
                                                                                                                                                    } else {
                                                                                                                                                        if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.91) {
                                                                                                                                                            buckets_mimics_nb = 0.5;
                                                                                                                                                        } else {
                                                                                                                                                            if (nb_mimics_model4 == 0.71 && nb_mimics_model3 == 0.93) {
                                                                                                                                                                buckets_mimics_nb = 0.5;
                                                                                                                                                            } else {
                                                                                                                                                                if (nb_mimics_model4 == 0.74) {
                                                                                                                                                                    buckets_mimics_nb = 0.74;
                                                                                                                                                                } else {
                                                                                                                                                                    if (nb_mimics_model4 == 0.75) {
                                                                                                                                                                        buckets_mimics_nb = 0.75;
                                                                                                                                                                    } else {
                                                                                                                                                                        if (nb_mimics_model4 == 0.83) {
                                                                                                                                                                            buckets_mimics_nb = 0.85;
                                                                                                                                                                        } else {
                                                                                                                                                                            if (nb_mimics_model4 == 0.85) {
                                                                                                                                                                                buckets_mimics_nb = 0.87;
                                                                                                                                                                            } else {
                                                                                                                                                                                if (nb_mimics_model4 == 0.86) {
                                                                                                                                                                                    buckets_mimics_nb = 0.92;
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (nb_mimics_model4 == 0.91) {
                                                                                                                                                                                        buckets_mimics_nb = 0.92;
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (nb_mimics_model4 == 0.93) {
                                                                                                                                                                                            buckets_mimics_nb = 0.93;
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (nb_mimics_model4 == 0.94) {
                                                                                                                                                                                                buckets_mimics_nb = 0.93;
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }

                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

/*
 * Bucket NB ensemble model for classification of ischaemic stroke
 */
                                if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0) {
                                    buckets_ischaemic_nb = 0.4;
                                } else {
                                    if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.04) {
                                        buckets_ischaemic_nb = 0.24;
                                    } else {
                                        if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.18) {
                                            buckets_ischaemic_nb = 0.5;
                                        } else {
                                            if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.55) {
                                                buckets_ischaemic_nb = 0.33;
                                            } else {
                                                if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.93) {
                                                    buckets_ischaemic_nb = 0.12;
                                                } else {
                                                    if (nb_haemorrhagic_model4 == 0.05 && cart_haemorrhagic_model3 == 0) {
                                                        buckets_ischaemic_nb = 0.56;
                                                    } else {
                                                        if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.04) {
                                                            buckets_ischaemic_nb = 0.27;
                                                        } else {
                                                            if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.18) {
                                                                buckets_ischaemic_nb = 0.5;
                                                            } else {
                                                                if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.55) {
                                                                    buckets_ischaemic_nb = 0.5;
                                                                } else {
                                                                    if (nb_haemorrhagic_model4 == 0.04 && cart_haemorrhagic_model3 == 0.93) {
                                                                        buckets_ischaemic_nb = 0.5;
                                                                    } else {
                                                                        if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.19) {
                                                                            buckets_ischaemic_nb = 0.14;
                                                                        } else {
                                                                            if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.25) {
                                                                                buckets_ischaemic_nb = 0.5;
                                                                            } else {
                                                                                if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.29) {
                                                                                    buckets_ischaemic_nb = 0.75;
                                                                                } else {
                                                                                    if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.59) {
                                                                                        buckets_ischaemic_nb = 0.06;
                                                                                    } else {
                                                                                        if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.84) {
                                                                                            buckets_ischaemic_nb = 0.5;
                                                                                        } else {
                                                                                            if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 0.93) {
                                                                                                buckets_ischaemic_nb = 0.5;
                                                                                            } else {
                                                                                                if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0 && cart_mimics_model3 == 1) {
                                                                                                    buckets_ischaemic_nb = 0.5;
                                                                                                } else {
                                                                                                    if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0.04) {
                                                                                                        buckets_ischaemic_nb = 0.5;
                                                                                                    } else {
                                                                                                        if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0.18) {
                                                                                                            buckets_ischaemic_nb = 0.5;
                                                                                                        } else {
                                                                                                            if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0.55) {
                                                                                                                buckets_ischaemic_nb = 0.33;
                                                                                                            } else {
                                                                                                                if (nb_haemorrhagic_model4 == 0.06 && cart_haemorrhagic_model3 == 0.93) {
                                                                                                                    buckets_ischaemic_nb = 0.07;
                                                                                                                } else {
                                                                                                                    if (nb_haemorrhagic_model4 == 0.07) {
                                                                                                                        buckets_ischaemic_nb = 0.21;
                                                                                                                    } else {
                                                                                                                        if (nb_haemorrhagic_model4 == 0.08) {
                                                                                                                            buckets_ischaemic_nb = 0.25;
                                                                                                                        } else {
                                                                                                                            if (nb_haemorrhagic_model4 == 0.09) {
                                                                                                                                buckets_ischaemic_nb = 0.04;
                                                                                                                            } else {
                                                                                                                                if (nb_haemorrhagic_model4 == 0.13) {
                                                                                                                                    buckets_ischaemic_nb = 0.14;
                                                                                                                                } else {
                                                                                                                                    if (nb_haemorrhagic_model4 == 0.14) {
                                                                                                                                        buckets_ischaemic_nb = 0.03;
                                                                                                                                    } else {
                                                                                                                                        if (nb_haemorrhagic_model4 == 0.18) {
                                                                                                                                            buckets_ischaemic_nb = 0.27;
                                                                                                                                        } else {
                                                                                                                                            if (nb_haemorrhagic_model4 == 0.2) {
                                                                                                                                                buckets_ischaemic_nb = 0.24;
                                                                                                                                            } else {
                                                                                                                                                if (nb_haemorrhagic_model4 == 0.23) {
                                                                                                                                                    buckets_ischaemic_nb = 0.19;
                                                                                                                                                } else {
                                                                                                                                                    if (nb_haemorrhagic_model4 == 0.25) {
                                                                                                                                                        buckets_ischaemic_nb = 0.15;
                                                                                                                                                    } else {
                                                                                                                                                        if (nb_haemorrhagic_model4 == 0.26) {
                                                                                                                                                            buckets_ischaemic_nb = 0.13;
                                                                                                                                                        } else {
                                                                                                                                                            if (nb_haemorrhagic_model4 == 0.33) {
                                                                                                                                                                buckets_ischaemic_nb = 0.07;
                                                                                                                                                            } else {
                                                                                                                                                                if (nb_haemorrhagic_model4 == 0.46) {
                                                                                                                                                                    buckets_ischaemic_nb = 0.06;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

/*
 * Bucket NB ensemble model for classification of haemorrhagic stroke
 */
                                if (nb_haemorrhagic_model3 == 0.01) {
                                    buckets_haemorrhagic_nb = 0.01;
                                } else {
                                    if (nb_haemorrhagic_model3 == 0.04) {
                                        buckets_haemorrhagic_nb = 0.04;
                                    } else {
                                        if (nb_haemorrhagic_model3 == 0.08) {
                                            buckets_haemorrhagic_nb = 0.06;
                                        } else {
                                            if (nb_haemorrhagic_model3 == 0.11) {
                                                buckets_haemorrhagic_nb = 0.11;
                                            } else {
                                                if (nb_haemorrhagic_model3 == 0.12) {
                                                    buckets_haemorrhagic_nb = 0.13;
                                                } else {
                                                    if (nb_haemorrhagic_model3 == 0.13) {
                                                        buckets_haemorrhagic_nb = 0.12;
                                                    } else {
                                                        if (nb_haemorrhagic_model3 == 0.16) {
                                                            buckets_haemorrhagic_nb = 0.15;
                                                        } else {
                                                            if (nb_haemorrhagic_model3 == 0.17) {
                                                                buckets_haemorrhagic_nb = 0.17;
                                                            } else {
                                                                if (nb_haemorrhagic_model3 == 0.18) {
                                                                    buckets_haemorrhagic_nb = 0.18;
                                                                } else {
                                                                    if (nb_haemorrhagic_model3 == 0.19) {
                                                                        buckets_haemorrhagic_nb = 0.2;
                                                                    } else {
                                                                        if (nb_haemorrhagic_model3 == 0.25) {
                                                                            buckets_haemorrhagic_nb = 0.25;
                                                                        } else {
                                                                            if (nb_haemorrhagic_model3 == 0.26) {
                                                                                buckets_haemorrhagic_nb = 0.22;
                                                                            } else {
                                                                                if (nb_haemorrhagic_model3 == 0.27) {
                                                                                    buckets_haemorrhagic_nb = 0.27;
                                                                                } else {
                                                                                    if (nb_haemorrhagic_model3 == 0.37) {
                                                                                        buckets_haemorrhagic_nb = 0.38;
                                                                                    } else {
                                                                                        if (nb_haemorrhagic_model3 == 0.39) {
                                                                                            buckets_haemorrhagic_nb = 0.38;
                                                                                        } else {
                                                                                            if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0) {
                                                                                                buckets_haemorrhagic_nb = 0.15;
                                                                                            } else {
                                                                                                if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0.05) {
                                                                                                    buckets_haemorrhagic_nb = 0.13;
                                                                                                } else {
                                                                                                    if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0.13) {
                                                                                                        buckets_haemorrhagic_nb = 0.33;
                                                                                                    } else {
                                                                                                        if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0.2) {
                                                                                                            buckets_haemorrhagic_nb = 0.5;
                                                                                                        } else {
                                                                                                            if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0.53) {
                                                                                                                buckets_haemorrhagic_nb = 0.38;
                                                                                                            } else {
                                                                                                                if (nb_haemorrhagic_model3 == 0.15 && cart_haemorrhagic_model1 == 0.57) {
                                                                                                                    buckets_haemorrhagic_nb = 0.33;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

/*
 * Stacking NB ensemble model for classification of stroke mimics
 */
                                if (nb_mimics_model4 == 0.29) {
                                    stacking_mimics_nb = 0.29;
                                } else {
                                    if (nb_mimics_model4 == 0.32) {
                                        stacking_mimics_nb = 0.3;
                                    } else {
                                        if (nb_mimics_model4 == 0.37) {
                                            stacking_mimics_nb = 0.33;
                                        } else {
                                            if (nb_mimics_model4 == 0.6) {
                                                stacking_mimics_nb = 0.61;
                                            } else {
                                                if (nb_mimics_model4 == 0.61) {
                                                    stacking_mimics_nb = 0.61;
                                                } else {
                                                    if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.19) {
                                                        stacking_mimics_nb = 0.76;
                                                    } else {
                                                        if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.25) {
                                                            stacking_mimics_nb = 0.5;
                                                        } else {
                                                            if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.29) {
                                                                stacking_mimics_nb = 0.28;
                                                            } else {
                                                                if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.59) {
                                                                    stacking_mimics_nb = 0.95;
                                                                } else {
                                                                    if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.84) {
                                                                        stacking_mimics_nb = 0.5;
                                                                    } else {
                                                                        if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.93) {
                                                                            stacking_mimics_nb = 0.5;
                                                                        } else {
                                                                            if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.1) {
                                                                                stacking_mimics_nb = 0.5;
                                                                            } else {
                                                                                if (nb_mimics_model4 == 0.67) {
                                                                                    stacking_mimics_nb = 0.67;
                                                                                } else {
                                                                                    if (nb_mimics_model4 == 0.71) {
                                                                                        stacking_mimics_nb = 0.73;
                                                                                    } else {
                                                                                        if (nb_mimics_model4 == 0.74) {
                                                                                            stacking_mimics_nb = 0.74;
                                                                                        } else {
                                                                                            if (nb_mimics_model4 == 0.75) {
                                                                                                stacking_mimics_nb = 0.75;
                                                                                            } else {
                                                                                                if (nb_mimics_model4 == 0.83) {
                                                                                                    stacking_mimics_nb = 0.85;
                                                                                                } else {
                                                                                                    if (nb_mimics_model4 == 0.85) {
                                                                                                        stacking_mimics_nb = 0.87;
                                                                                                    } else {
                                                                                                        if (nb_mimics_model4 == 0.86) {
                                                                                                            stacking_mimics_nb = 0.92;
                                                                                                        } else {
                                                                                                            if (nb_mimics_model4 == 0.91) {
                                                                                                                stacking_mimics_nb = 0.92;
                                                                                                            } else {
                                                                                                                if (nb_mimics_model4 == 0.93) {
                                                                                                                    stacking_mimics_nb = 0.93;
                                                                                                                } else {
                                                                                                                    if (nb_mimics_model4 == 0.94) {
                                                                                                                        stacking_mimics_nb = 0.93;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                /**
                                 * Stacking NB ensemble model for classification of ischaemic stroke
                                 */
                                if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.02) {
                                    stacking_ischaemic_nb = 0.02;
                                } else {
                                    if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.03) {
                                        stacking_ischaemic_nb = 0.03;
                                    } else {
                                        if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.09 && cart_ischaemic_model4 == 0) {
                                            stacking_ischaemic_nb = 0.09;
                                        } else {
                                            if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.09 && cart_ischaemic_model4 == 0.05) {
                                                stacking_ischaemic_nb = 0.09;
                                            } else {
                                                if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.09 && cart_ischaemic_model4 == 0.27) {
                                                    stacking_ischaemic_nb = 0.5;
                                                } else {
                                                    if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.09 && cart_ischaemic_model4 == 0.37) {
                                                        stacking_ischaemic_nb = 0.5;
                                                    } else {
                                                        if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.09 && cart_ischaemic_model4 == 0.76) {
                                                            stacking_ischaemic_nb = 0.33;
                                                        } else {
                                                            if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.23) {
                                                                stacking_ischaemic_nb = 0.5;
                                                            } else {
                                                                if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.25) {
                                                                    stacking_ischaemic_nb = 0.5;
                                                                } else {
                                                                    if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.28) {
                                                                        stacking_ischaemic_nb = 0.5;
                                                                    } else {
                                                                        if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.29) {
                                                                            stacking_ischaemic_nb = 0.5;
                                                                        } else {
                                                                            if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.3) {
                                                                                stacking_ischaemic_nb = 0.3;
                                                                            } else {
                                                                                if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.54) {
                                                                                    stacking_ischaemic_nb = 0.56;
                                                                                } else {
                                                                                    if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.72) {
                                                                                        stacking_ischaemic_nb = 0.5;
                                                                                    } else {
                                                                                        if (cart_ischaemic_model5 == 0.06 && nb_ischaemic_model5 == 0.77) {
                                                                                            stacking_ischaemic_nb = 0.5;
                                                                                        } else {
                                                                                            if (cart_ischaemic_model5 == 0.22) {
                                                                                                stacking_ischaemic_nb = 0.2;
                                                                                            } else {
                                                                                                if (cart_ischaemic_model5 == 0.71 && cart_ischaemic_model3 == 0.04) {
                                                                                                    stacking_ischaemic_nb = 0.5;
                                                                                                } else {
                                                                                                    if (cart_ischaemic_model5 == 0.71 && cart_ischaemic_model3 == 0.22) {
                                                                                                        stacking_ischaemic_nb = 0.5;
                                                                                                    } else {
                                                                                                        if (cart_ischaemic_model5 == 0.71 && cart_ischaemic_model3 == 0.33) {
                                                                                                            stacking_ischaemic_nb = 0.8;
                                                                                                        } else {
                                                                                                            if (cart_ischaemic_model5 == 0.71 && cart_ischaemic_model3 == 0.62) {
                                                                                                                stacking_ischaemic_nb = 0.5;
                                                                                                            } else {
                                                                                                                if (cart_ischaemic_model5 == 0.71 && cart_ischaemic_model3 == 0.81) {
                                                                                                                    stacking_ischaemic_nb = 0.38;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }

                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                /**
                                 * Stacking NB ensemble model for classifidation of haemorrhagic stroke
                                 */
                                if (nb_mimics_model4 == 0.29) {
                                    stacking_haemorrhagic_nb = 0.03;
                                } else {
                                    if (nb_mimics_model4 == 0.32) {
                                        stacking_haemorrhagic_nb = 0.4;
                                    } else {
                                        if (nb_mimics_model4 == 0.37) {
                                            stacking_haemorrhagic_nb = 0.2;
                                        } else {
                                            if (nb_mimics_model4 == 0.6) {
                                                stacking_haemorrhagic_nb = 0.21;
                                            } else {
                                                if (nb_mimics_model4 == 0.61) {
                                                    stacking_haemorrhagic_nb = 0.39;
                                                } else {
                                                    if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.19) {
                                                        stacking_haemorrhagic_nb = 0.17;
                                                    } else {
                                                        if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.25) {
                                                            stacking_haemorrhagic_nb = 0.5;
                                                        } else {
                                                            if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.29) {
                                                                stacking_haemorrhagic_nb = 0.08;
                                                            } else {
                                                                if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.59) {
                                                                    stacking_haemorrhagic_nb = 0.05;
                                                                } else {
                                                                    if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.84) {
                                                                        stacking_haemorrhagic_nb = 0.5;
                                                                    } else {
                                                                        if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 0.93) {
                                                                            stacking_haemorrhagic_nb = 0.5;
                                                                        } else {
                                                                            if (nb_mimics_model4 == 0.65 && cart_mimics_model3 == 1) {
                                                                                stacking_haemorrhagic_nb = 0.5;
                                                                            } else {
                                                                                if (nb_mimics_model4 == 0.67) {
                                                                                    stacking_haemorrhagic_nb = 0.28;
                                                                                } else {
                                                                                    if (nb_mimics_model4 == 0.71) {
                                                                                        stacking_haemorrhagic_nb = 0.24;
                                                                                    } else {
                                                                                        if (nb_mimics_model4 == 0.74) {
                                                                                            stacking_haemorrhagic_nb = 0.04;
                                                                                        } else {
                                                                                            if (nb_mimics_model4 == 0.75) {
                                                                                                stacking_haemorrhagic_nb = 0.13;
                                                                                            } else {
                                                                                                if (nb_mimics_model4 == 0.83) {
                                                                                                    stacking_haemorrhagic_nb = 0.11;
                                                                                                } else {
                                                                                                    if (nb_mimics_model4 == 0.85) {
                                                                                                        stacking_haemorrhagic_nb = 0.11;
                                                                                                    } else {
                                                                                                        if (nb_mimics_model4 == 0.86) {
                                                                                                            stacking_haemorrhagic_nb = 0.08;
                                                                                                        } else {
                                                                                                            if (nb_mimics_model4 == 0.91) {
                                                                                                                stacking_haemorrhagic_nb = 0.08;
                                                                                                            } else {
                                                                                                                if (nb_mimics_model4 == 0.93) {
                                                                                                                    stacking_haemorrhagic_nb = 0.04;
                                                                                                                } else {
                                                                                                                    if (nb_mimics_model4 == 0.94) {
                                                                                                                        stacking_haemorrhagic_nb = 0.07;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                /**
                                 * Hybrid model for classification of stroke mimics
                                 */
                                if (buckets_mimics_cart < 0.5) {
                                    if (stacking_mimics_cart < 0.35) {
                                        probability_mimics = 0.02;
                                    } else {
                                        if (stacking_ischaemic_cart >= 0.085) {
                                            probability_mimics = 0.25;
                                        } else {
                                            probability_mimics = 1;
                                        }
                                    }
                                } else {
                                    if (stacking_mimics_nb < 0.9) {
                                        if (stacking_mimics_cart < 0.5) {
                                            if (buckets_haemorrhagic_nb >= 0.16) {
                                                probability_mimics = 0.25;
                                            } else {
                                                probability_mimics = 0.9;
                                            }
                                        } else {
                                            if (stacking_haemorrhagic_nb >= 0.11) {
                                                if (buckets_ischaemic_nb >= 0.065) {
                                                    if (buckets_haemorrhagic_nb >= 0.075) {
                                                        if (buckets_haemorrhagic_nb >= 0.34) {
                                                            probability_mimics = 0.57;
                                                        } else {
                                                            if (buckets_mimics_nb >= 0.73) {
                                                                if (buckets_haemorrhagic_cart >= 0.17) {
                                                                    if (stacking_ischaemic_nb >= 0.055) {
                                                                        probability_mimics = 0.4;
                                                                    } else {
                                                                        probability_mimics = 0.7;
                                                                    }
                                                                } else {
                                                                    probability_mimics = 0.81;
                                                                }
                                                            } else {
                                                                probability_mimics = 0.94;
                                                            }
                                                        }
                                                    } else {
                                                        probability_mimics = 1;
                                                    }
                                                } else {
                                                    probability_mimics = 0.95;
                                                }
                                            } else {
                                                probability_mimics = 1;
                                            }
                                        }
                                    } else {
                                        probability_mimics = 1;
                                    }
                                }

                            }
                        }
                    }
                }

                /**
                 * Hybrid model for classification of ischaemic stroke
                 */
                if (stacking_ischaemic_cart < 0.4) {
                    if (stacking_mimics_nb >= 0.47) {
                        probability_ischaemic = 0.04;
                    } else {
                        if (stacking_ischaemic_nb < 0.14) {
                            probability_ischaemic = 0;
                        } else {
                            if (stacking_mimics_cart >= 0.5) {
                                probability_ischaemic = 0.17;
                            } else {
                                probability_ischaemic = 0.6;
                            }
                        }
                    }
                } else {
                    if (buckets_mimics_cart >= 0.5) {
                        probability_ischaemic = 0;
                    } else {
                        if (stacking_haemorrhagic_nb >= 0.29) {
                            probability_ischaemic = 0.38;
                        } else {
                            probability_ischaemic = 0.92;
                        }
                    }
                }

                /**
                 * Hybrid model for classification of haemorrhagic stroke
                 */
                if (buckets_haemorrhagic_cart < 0.17) {
                    probability_hstroke = 0.02;
                } else {
                    if (buckets_haemorrhagic_cart < 0.71) {
                        if (stacking_haemorrhagic_cart < 0.29) {
                            probability_hstroke = 0.13;
                        } else {
                            if (stacking_mimics_cart >= 0.56) {
                                probability_hstroke = 0.27;
                            } else {
                                probability_hstroke = 0.8;
                            }
                        }
                    } else {
                        if (buckets_mimics_nb >= 0.64) {
                            probability_hstroke = 0.4;
                        } else {
                            probability_hstroke = 1;
                        }
                    }
                }

                double prob_mimics_update;
                if(probability_hstroke < 0.05 && probability_ischaemic < 0.05){
                    prob_mimics_update = 0.9;
                }
                else {
                    prob_mimics_update = probability_mimics;
                }

                NIHSSscore = sconsciousnesstrans_value + sLOCquestions_value + sLOCcommandstrans_value + sBestgazetrans_value +
                        svisualtrans_value + sfacialparesisgroup_value + leftarmtrans_value + rightarmtrans_value +
                        leftlegtrans_value + rightlegtrans_value + limbataxiatrans_value + sensorytrans_value + languagetrans_value +
                        sdysarghria_value + extinctiontrans_value;

                GCSscore = seyeresponse_value + smotorresponse_value + sverbalresponse_value;

                triageDBHandler db = new triageDBHandler(stroke.this);

                db.getWritableDatabase();
                Strokepatient strokepatient = new Strokepatient(studyid,birthyearint, birthmonthint, birthdayint, symptomyearint, symptommonthint,
                        symptomdayint,arrivalyearint,arrivalmonthint,arrivaldayint, symptomhourint,symptomminint,arrivalhourint,arrivalminint,
                        patientage,sgendervalue,spmhxvalue,swoke_value, swellweekb4value,smedicaltransportvalue,shighcategory_value,
                        svertigovalue,sheadache_value,svomit_value,ssuddenvalue,simprovevalue,sdizziness_value,sspeechloss_value,sfocalnumb_value,sfocalweak_value,sseizure_value,smentalstate_value,
                        sloc_value,svision_value,sataxia_value,sother_value,sreferred_value,sphotophobia_value,
                        sphonophobia_value,spupils_value,seyeresponse_value,sverbalresponse_value,smotorresponse_value,sconsciousnesstrans_value,
                        sLOCquestions_value,sLOCcommandstrans_value,sBestgazetrans_value,svisualtrans_value,sfacialparesisgroup_value,leftarmtrans_value,
                        leftlegtrans_value,rightarmtrans_value,rightlegtrans_value,sweakhand_value,limbataxiatrans_value,ssensearm_value,
                        ssenseleg_value,ssenseface_value,sensorytrans_value,languagetrans_value,sdysarghria_value,dysarthriatrans_value,
                        extinctiontrans_value,ssenseneg_value,swalknotokcrf2_value,sother2_value);

                db.addHandler1(strokepatient);
                db.close();

                Intent intent = new Intent();
                intent.putExtra("nihssscore", NIHSSscore);
                intent.putExtra("gcsscore", GCSscore);
                intent.putExtra("ischaemic", probability_ischaemic);
                intent.putExtra("haemorrhagic", probability_hstroke);
                intent.putExtra("strokemimics", prob_mimics_update);
                intent.setClass(stroke.this, calculatorstroke.class);
                startActivity(intent);
            }

    });
    }
}
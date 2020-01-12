package com.example.qi.paediatricstroketriagetool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class triageDBHandler extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 19;
    private final static String DATABASE_NAME = "patient.db";

    public static final String TABLE_Triage = "triage";
    public static final String TABLE_STROKE = "stroke";

    public static final String Study_ID = "studyid";
    public static final String Patient_Birthyear = "birthyear";
    public static final String Patient_Birthmonth = "birthmonth";
    public static final String Patient_Birthday = "birthday";
    public static final String Patient_Symptomyear = "symptomyear";
    public static final String Patient_Symptommonth = "symptommonth";
    public static final String Patient_Symptomday = "symptomday";
    public static final String Patient_Arrivalyear = "arrivalyear";
    public static final String Patient_Arrivalmonth = "arrivalmonth";
    public static final String Patient_Arrivalday = "arrivalday";
    public static final String Patient_Symptomhour = "symptomhour";
    public static final String Patient_Symptommin = "symptommin";
    public static final String Patient_Arrivalhour = "arrivalhour";
    public static final String Patient_Arrivalmin = "arrivalmin";
    public static final String Patient_Age = "age";
    public static final String Patient_Gender = "gender";
    public static final String Patient_Pmhx = "pmhx";
    public static final String Patient_Woke = "woke";
    public static final String Patient_Wellweekb4 = "wellweekb4";
    public static final String Patient_Medicaltransport = "medicaltransport";
    public static final String Patient_Highcategory = "highcategory";
    public static final String Patient_Vertigo = "vertigo";
    public static final String Patient_Headace = "headace";
    public static final String Patient_Vomit = "vomit";
    public static final String Patient_Dizziness = "dizziness";
    public static final String Patient_Speechloss = "speechloss";
    public static final String Patient_Focalnumb = "focalnumb";
    public static final String Patient_Focalweek = "focalweek";
    public static final String Patient_Seizure = "seizure";
    public static final String Patient_Mentalstate = "mentalstate";
    public static final String Patient_Loc = "loc";
    public static final String Patient_Vision = "vision";
    public static final String Patient_Ataxia = "ataxia";
    public static final String Patient_Other = "other";
    public static final String Patient_Sudden = "sudden";
    public static final String Patient_Improving = "improving";
    public static final String Patient_Referred = "referred";
    public static final String Patient_Photophobia = "photophobia";
    public static final String Patient_Phonophobia = "phonophobia";

    public static final String Study_SID = "studyid";
    public static final String Patient_SBirthyear = "birthyear";
    public static final String Patient_SBirthmonth = "birthmonth";
    public static final String Patient_SBirthday = "birthday";
    public static final String Patient_SSymptomyear = "symptomyear";
    public static final String Patient_SSymptommonth = "symptommonth";
    public static final String Patient_SSymptomday = "symptomday";
    public static final String Patient_SArrivalyear = "arrivalyear";
    public static final String Patient_SArrivalmonth = "arrivalmonth";
    public static final String Patient_SArrivalday = "arrivalday";
    public static final String Patient_SSymptomhour = "symptomhour";
    public static final String Patient_SSymptommin = "symptommin";
    public static final String Patient_SArrivalhour = "arrivalhour";
    public static final String Patient_SArrivalmin = "arrivalmin";
    public static final String Patient_SAge = "age";
    public static final String Patient_SGender = "gender";
    public static final String Patient_SPmhx = "pmhx";
    public static final String Patient_SWoke = "woke";
    public static final String Patient_SWellweekb4 = "wellweekb4";
    public static final String Patient_SMedicaltransport = "medicaltransport";
    public static final String Patient_SHighcategory = "highcategory";
    public static final String Patient_SVertigo = "vertigo";
    public static final String Patient_SHeadace = "headace";
    public static final String Patient_SVomit = "vomit";
    public static final String Patient_SDizziness = "dizziness";
    public static final String Patient_SSpeechloss = "speechloss";
    public static final String Patient_SFocalnumb = "focalnumb";
    public static final String Patient_SFocalweek = "focalweek";
    public static final String Patient_SSeizure = "seizure";
    public static final String Patient_SMentalstate = "mentalstate";
    public static final String Patient_SLoc = "loc";
    public static final String Patient_SVision = "vision";
    public static final String Patient_SAtaxia = "ataxia";
    public static final String Patient_SOther = "other";
    public static final String Patient_SSudden = "sudden";
    public static final String Patient_SImproving = "improving";
    public static final String Patient_SReferred = "referred";
    public static final String Patient_SPhotophobia = "photophobia";
    public static final String Patient_SPhonophobia = "phonophobia";
    public static final String Patient_Pupils = "pupils";
    public static final String Patient_SEyeresponse = "eyeresponse";
    public static final String Patient_SVerbalresponse = "verbalresponse";
    public static final String Patient_SMotorresponse = "motorresponse";
    public static final String Patient_SConscioiusness = "consciousness";
    public static final String Patient_SLOCquestions = "LOCquestions";
    public static final String Patient_SLOCcommands = "LOCcommands";
    public static final String Patient_SBestgaze = "bestgaze";
    public static final String Patient_SVisualfield = "visualfield";
    public static final String Patient_SFacialpalsy = "facialpalsy";
    public static final String Patient_SLeftarm = "leftarm";
    public static final String Patient_SLeftleg = "leftleg";
    public static final String Patient_SRightarm = "rightarm";
    public static final String Patient_SRightleg = "rightleg";
    public static final String Patient_SWeekhand = "weekhand";
    public static final String Patient_SLimbataxia = "limbataxia";
    public static final String Patient_SSensearm = "sensearm";
    public static final String Patient_SSenseleg = "senselg";
    public static final String Patient_SSenseface = "sensefact";
    public static final String Patient_SSensory = "sensory";
    public static final String Patient_SLanguage = "language";
    public static final String Patient_SDysarghria = "dysarghria";
    public static final String Patient_SDysarthria = "dysarthria";
    public static final String Patient_SExtinction = "extinction";
    public static final String Patient_SSenseneg = "senseneg";
    public static final String Patient_SWalknotokcrf2 = "walknotokcrf2";
    public static final String Patient_SOther2 = "others";

    public triageDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_Triage + "("
            + Study_ID + " INTEGER PRIMARY KEY,"
            + Patient_Birthyear + " INTERGER,"
            + Patient_Birthmonth + " INTERGER,"
            + Patient_Birthday + " INTERGER,"
            + Patient_Symptomyear + " INTERGER,"
            + Patient_Symptommonth + " INTERGER,"
            + Patient_Symptomday + " INTERGER,"
            + Patient_Arrivalyear + " INTERGER,"
            + Patient_Arrivalmonth + " INTERGER,"
            + Patient_Arrivalday + " INTERGER,"
            + Patient_Symptomhour + " INTEGER,"
            + Patient_Symptommin + " INTEGER,"
            + Patient_Arrivalhour + " INTEGER,"
            + Patient_Arrivalmin + " INTEGER,"
            + Patient_Age + " INTEGER,"
            + Patient_Gender + " INTEGER,"
            + Patient_Pmhx + " INTEGER,"
            + Patient_Woke + " INTEGER,"
            + Patient_Wellweekb4 + " INTEGER,"
            + Patient_Medicaltransport + " INTEGER,"
            + Patient_Highcategory + " INTEGER,"
            + Patient_Vertigo + " INTEGER,"
            + Patient_Headace + " INTEGER,"
            + Patient_Vomit + " INTEGER,"
            + Patient_Dizziness + " INTEGER,"
            + Patient_Speechloss + " INTEGER,"
            + Patient_Focalnumb + " INTEGER,"
            + Patient_Focalweek + " INTEGER,"
            + Patient_Seizure + " INTEGER,"
            + Patient_Mentalstate + " INTEGER,"
            + Patient_Loc + " INTEGER,"
            + Patient_Vision + " INTEGER,"
            + Patient_Ataxia + " INTEGER,"
            + Patient_Other + " INTEGER,"
            + Patient_Sudden + " INTERGER,"
            + Patient_Improving + " INTERGER,"
            + Patient_Referred + " INTERGER,"
            + Patient_Phonophobia + " INTERGER,"
            + Patient_Photophobia + " INTERGER" + ")";

   private static final String CREATE_STROKE_TABLE = "CREATE TABLE " + TABLE_STROKE + "("
            + Study_SID + " INTEGER PRIMARY KEY,"
            + Patient_SBirthyear + " INTERGER,"
            + Patient_SBirthmonth + " INTERGER,"
            + Patient_SBirthday + " INTERGER,"
            + Patient_SSymptomyear + " INTERGER,"
            + Patient_SSymptommonth + " INTERGER,"
            + Patient_SSymptomday + " INTERGER,"
            + Patient_SArrivalyear + " INTERGER,"
            + Patient_SArrivalmonth + " INTERGER,"
            + Patient_SArrivalday + " INTERGER,"
            + Patient_SSymptomhour + " INTEGER,"
            + Patient_SSymptommin + " INTEGER,"
            + Patient_SArrivalhour + " INTEGER,"
            + Patient_SArrivalmin + " INTEGER,"
            + Patient_SAge + " INTEGER,"
            + Patient_SGender + " INTEGER,"
            + Patient_SPmhx + " INTEGER,"
            + Patient_SWoke + " INTEGER,"
            + Patient_SWellweekb4 + " INTEGER,"
            + Patient_SMedicaltransport + " INTEGER,"
            + Patient_SHighcategory + " INTERGER,"
            + Patient_SVertigo + " INTEGER,"
            + Patient_SHeadace + " INTEGER,"
            + Patient_SVomit + " INTEGER,"
            + Patient_SDizziness + " INTEGER,"
            + Patient_SSpeechloss + " INTEGER,"
            + Patient_SFocalnumb + " INTEGER,"
            + Patient_SFocalweek + " INTEGER,"
            + Patient_SSeizure + " INTEGER,"
            + Patient_SMentalstate + " INTEGER,"
            + Patient_SLoc + " INTEGER,"
            + Patient_SVision + " INTEGER,"
            + Patient_SAtaxia + " INTEGER,"
            + Patient_SOther + " INTEGER,"
            + Patient_SSudden + " INTERGER,"
            + Patient_SImproving + " INTERGER,"
            + Patient_SReferred + " INTERGER,"
            + Patient_SPhotophobia + " INTEGER,"
            + Patient_SPhonophobia + " INTEGER,"
            + Patient_Pupils + " INTEGER,"
            + Patient_SEyeresponse + " INTEGER,"
            + Patient_SVerbalresponse + " INTEGER,"
            + Patient_SMotorresponse + " INTEGER,"
            + Patient_SConscioiusness + " INTEGER,"
            + Patient_SLOCquestions + " INTEGER,"
            + Patient_SLOCcommands + " INTEGER,"
            + Patient_SBestgaze + " INTEGER,"
            + Patient_SVisualfield + " INTEGER,"
            + Patient_SFacialpalsy + " INTEGER,"
            + Patient_SLeftarm + " INTEGER,"
            + Patient_SLeftleg + " INTEGER,"
            + Patient_SRightarm + " INTEGER,"
            + Patient_SRightleg + " INTEGER,"
            + Patient_SWeekhand + " INTEGER,"
            + Patient_SLimbataxia + " INTEGER,"
            + Patient_SSensearm + " INTEGER,"
            + Patient_SSenseleg + " INTEGER,"
            + Patient_SSenseface + " INTEGER,"
            + Patient_SSensory + " INTEGER,"
            + Patient_SLanguage + " INTEGER,"
            + Patient_SDysarghria + " INTEGER,"
            + Patient_SDysarthria + " INTEGER,"
            + Patient_SExtinction + " INTEGER,"
            + Patient_SSenseneg + " INTEGER,"
            + Patient_SWalknotokcrf2 + " INTEGER,"
            + Patient_SOther2 + " INTERGER" + ")";

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_PATIENT_TABLE);
        db.execSQL(CREATE_STROKE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_Triage);
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_STROKE);
      onCreate(db);
    }

    public void addHandler(Triagepatient triagepatient){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values2 = new ContentValues();
        values2.put(Study_ID, triagepatient.getStudyid());
        values2.put(Patient_Birthyear, triagepatient.getBirthyear());
        values2.put(Patient_Birthmonth, triagepatient.getBirthmonth());
        values2.put(Patient_Birthday, triagepatient.getBirthday());
        values2.put(Patient_Symptomyear, triagepatient.getSymptomyear());
        values2.put(Patient_Symptommonth, triagepatient.getSymptommonth());
        values2.put(Patient_Symptomday, triagepatient.getSymptomday());
        values2.put(Patient_Arrivalyear, triagepatient.getArrivalyear());
        values2.put(Patient_Arrivalmonth, triagepatient.getArrivalmonth());
        values2.put(Patient_Arrivalday, triagepatient.getArrivalday());
        values2.put(Patient_Symptomhour, triagepatient.getSymptomhour());
        values2.put(Patient_Symptommin, triagepatient.getSymptommin());
        values2.put(Patient_Arrivalhour, triagepatient.getArrivalhour());
        values2.put(Patient_Arrivalmin, triagepatient.getArrivalmin());
        values2.put(Patient_Age, triagepatient.getAge());
        values2.put(Patient_Gender, triagepatient.getGender());
        values2.put(Patient_Pmhx, triagepatient.getPmhx());
        values2.put(Patient_Woke, triagepatient.getWoke());
        values2.put(Patient_Wellweekb4, triagepatient.getWellweekb4());
        values2.put(Patient_Medicaltransport, triagepatient.getMedicaltransport());
        values2.put(Patient_Highcategory, triagepatient.getHighcategory());
        values2.put(Patient_Vertigo, triagepatient.getVertigo());
        values2.put(Patient_Headace, triagepatient.getHeadace());
        values2.put(Patient_Vomit, triagepatient.getVomit());
        values2.put(Patient_Dizziness, triagepatient.getDizziness());
        values2.put(Patient_Speechloss, triagepatient.getSpeechloss());
        values2.put(Patient_Focalnumb, triagepatient.getFocalnumb());
        values2.put(Patient_Focalweek, triagepatient.getFocalweek());
        values2.put(Patient_Seizure, triagepatient.getSeizure());
        values2.put(Patient_Mentalstate, triagepatient.getMentalstate());
        values2.put(Patient_Loc, triagepatient.getLoc());
        values2.put(Patient_Vision, triagepatient.getVision());
        values2.put(Patient_Ataxia, triagepatient.getAtaxia());
        values2.put(Patient_Other, triagepatient.getOther());
        values2.put(Patient_Sudden, triagepatient.getSudden());
        values2.put(Patient_Improving, triagepatient.getImproving());
        values2.put(Patient_Referred, triagepatient.getReferred());
        values2.put(Patient_Phonophobia, triagepatient.getPhonophobia());
        values2.put(Patient_Photophobia, triagepatient.getPhotophobia());
        db2.insert(TABLE_Triage, null,values2);
        db2.close();
    }

      public void addHandler1(Strokepatient strokepatient){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put(Study_SID,strokepatient.getStudyid());
        values1.put(Patient_SBirthyear, strokepatient.getBirthyear());
        values1.put(Patient_SBirthmonth, strokepatient.getBirthmonth());
        values1.put(Patient_SBirthday, strokepatient.getBirthday());
        values1.put(Patient_SSymptomyear, strokepatient.getSymptomyear());
        values1.put(Patient_SSymptommonth, strokepatient.getSymptommonth());
        values1.put(Patient_SSymptomday, strokepatient.getSymptomday());
        values1.put(Patient_SArrivalyear, strokepatient.getArrivalyear());
        values1.put(Patient_SArrivalmonth, strokepatient.getArrivalmonth());
        values1.put(Patient_SArrivalday, strokepatient.getArrivalday());
        values1.put(Patient_SSymptomhour, strokepatient.getSymptomhour());
        values1.put(Patient_SSymptommin, strokepatient.getSymptommin());
        values1.put(Patient_SArrivalhour, strokepatient.getArrivalhour());
        values1.put(Patient_SArrivalmin, strokepatient.getArrivalmin());
        values1.put(Patient_SAge,strokepatient.getAge());
        values1.put(Patient_SGender,strokepatient.getGender());
        values1.put(Patient_SPmhx,strokepatient.getPmhx());
        values1.put(Patient_SWoke,strokepatient.getWoke());
        values1.put(Patient_SWellweekb4,strokepatient.getWellweekb4());
        values1.put(Patient_SMedicaltransport,strokepatient.getMedicaltransport());
        values1.put(Patient_SHighcategory, strokepatient.getHighcategory());
        values1.put(Patient_SVertigo,strokepatient.getVertigo());
        values1.put(Patient_SHeadace,strokepatient.getHeadace());
        values1.put(Patient_SVomit,strokepatient.getVomit());
        values1.put(Patient_SDizziness, strokepatient.getDizziness());
        values1.put(Patient_SSpeechloss, strokepatient.getSpeechloss());
        values1.put(Patient_SFocalnumb, strokepatient.getFocalnumb());
        values1.put(Patient_SFocalweek, strokepatient.getFocalweek());
        values1.put(Patient_SSeizure, strokepatient.getSeizure());
        values1.put(Patient_SMentalstate, strokepatient.getMentalstate());
        values1.put(Patient_SLoc, strokepatient.getLoc());
        values1.put(Patient_SVision, strokepatient.getVision());
        values1.put(Patient_SAtaxia, strokepatient.getAtaxia());
        values1.put(Patient_SOther, strokepatient.getOther());
        values1.put(Patient_SSudden, strokepatient.getSudden());
        values1.put(Patient_SImproving, strokepatient.getImproving());
        values1.put(Patient_SReferred, strokepatient.getReferred());
        values1.put(Patient_SPhotophobia, strokepatient.getPhotophobia());
        values1.put(Patient_SPhonophobia, strokepatient.getPhonophobia());
        values1.put(Patient_Pupils, strokepatient.getPupils());
        values1.put(Patient_SEyeresponse, strokepatient.getEyeresponse());
        values1.put(Patient_SVerbalresponse, strokepatient.getVerbalresponse());
        values1.put(Patient_SMotorresponse, strokepatient.getMotorresponse());
        values1.put(Patient_SConscioiusness, strokepatient.getConsciousness());
        values1.put(Patient_SLOCquestions, strokepatient.getLOCquestions());
        values1.put(Patient_SLOCcommands, strokepatient.getLOCcommands());
        values1.put(Patient_SBestgaze, strokepatient.getBestgaze());
        values1.put(Patient_SVisualfield, strokepatient.getVisualfield());
        values1.put(Patient_SFacialpalsy, strokepatient.getFacialpalsy());
        values1.put(Patient_SLeftarm, strokepatient.getLeftarm());
        values1.put(Patient_SLeftleg, strokepatient.getLeftleg());
        values1.put(Patient_SRightarm, strokepatient.getRightarm());
        values1.put(Patient_SRightleg, strokepatient.getRightleg());
        values1.put(Patient_SWeekhand, strokepatient.getWeakhand());
        values1.put(Patient_SLimbataxia, strokepatient.getLimbataxia());
        values1.put(Patient_SSensearm, strokepatient.getSensearm());
        values1.put(Patient_SSenseleg, strokepatient.getSenseleg());
        values1.put(Patient_SSenseface, strokepatient.getSenseface());
        values1.put(Patient_SSensory, strokepatient.getSensory());
        values1.put(Patient_SLanguage, strokepatient.getLanguage());
        values1.put(Patient_SDysarghria, strokepatient.getDysarthria());
        values1.put(Patient_SDysarthria, strokepatient.getDysarthria());
        values1.put(Patient_SExtinction, strokepatient.getExtinction());
        values1.put(Patient_SSenseneg, strokepatient.getSenseneg());
        values1.put(Patient_SWalknotokcrf2, strokepatient.getWalknotokcrf2());
        values1.put(Patient_SOther2, strokepatient.getOther2());
        db1.insert(TABLE_STROKE,null,values1);
        db1.close();
    }

    public Triagepatient findHandler(String patientid) {
        String query = "Select * FROM " + TABLE_Triage + " WHERE " + Study_ID + " = '" + patientid + "'";
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor cursor = db2.rawQuery(query, null);
        Triagepatient triagevalue = new Triagepatient();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            triagevalue.setStudyid(Integer.parseInt(cursor.getString(0)));
            triagevalue.setBirthyear(Integer.parseInt(cursor.getString(1)));
            triagevalue.setBirthmonth(Integer.parseInt(cursor.getString(2)));
            triagevalue.setBirthday(Integer.parseInt(cursor.getString(3)));
            triagevalue.setSymptomyear(Integer.parseInt(cursor.getString(4)));
            triagevalue.setSymptommonth(Integer.parseInt(cursor.getString(5)));
            triagevalue.setSymptomday(Integer.parseInt(cursor.getString(6)));
            triagevalue.setArrivalyear(Integer.parseInt(cursor.getString(7)));
            triagevalue.setArrivalmonth(Integer.parseInt(cursor.getString(8)));
            triagevalue.setArrivalday(Integer.parseInt(cursor.getString(9)));
            triagevalue.setSymptomhour(Integer.parseInt(cursor.getString(10)));
            triagevalue.setSymptommin(Integer.parseInt(cursor.getString(11)));
            triagevalue.setArrivalhour(Integer.parseInt(cursor.getString(12)));
            triagevalue.setArrivalmin(Integer.parseInt(cursor.getString(13)));
            triagevalue.setAge(cursor.getDouble(14));
            triagevalue.setGender(cursor.getInt(15));
            triagevalue.setPmhx(cursor.getInt(16));
            triagevalue.setWoke(cursor.getInt(17));
            triagevalue.setWellweekb4(cursor.getInt(18));
            triagevalue.setMedicaltransport(cursor.getInt(19));
            triagevalue.setHighcategory(cursor.getInt(20));
            triagevalue.setVertigo(cursor.getInt(21));
            triagevalue.setHeadace(cursor.getInt(22));
            triagevalue.setVomit(cursor.getInt(23));
            triagevalue.setDizziness(cursor.getInt(24));
            triagevalue.setSpeechloss(cursor.getInt(25));
            triagevalue.setFocalnumb(cursor.getInt(26));
            triagevalue.setFocalweek(cursor.getInt(27));
            triagevalue.setSeizure(cursor.getInt(28));
            triagevalue.setMentalstate(cursor.getInt(29));
            triagevalue.setLoc(cursor.getInt(30));
            triagevalue.setVision(cursor.getInt(31));
            triagevalue.setAtaxia(cursor.getInt(32));
            triagevalue.setOther(cursor.getInt(33));
            triagevalue.setSudden(cursor.getInt(34));
            triagevalue.setImproving(cursor.getInt(35));
            triagevalue.setReferred(cursor.getInt(36));
            triagevalue.setPhonophobia(cursor.getInt(37));
            triagevalue.setPhotophobia(cursor.getInt(38));
            cursor.close();
        } else {
            triagevalue = null;
        }
        db2.close();
        return triagevalue;
    }
}
package com.example.qi.paediatricstroketriagetool;

public class Triagepatient {

    private int studyid;
    private int birthyear;
    private int birthmonth;
    private int birthday;
    private int symptomyear;
    private int symptommonth;
    private int symptomday;
    private int arrivalyear;
    private int arrivalmonth;
    private int arrivalday;
    private int symptomhour;
    private int symptommin;
    private int arrivalhour;
    private int arrivalmin;
    private double age;
    private int gender;
    private int pmhx;
    private int woke;
    private int wellweekb4;
    private int medicaltransport;
    private int highcategory;
    private int vertigo;
    private int headace;
    private int vomit;
    private int dizziness;
    private int speechloss;
    private int focalnumb;
    private int focalweek;
    private int seizure;
    private int mentalstate;
    private int loc;
    private int vision;
    private int ataxia;
    private int other;
    private int sudden;
    private int improving;
    private int referred;
    private int phonophobia;
    private int photophobia;

    public Triagepatient() { }

    public Triagepatient(int _studyid, int _birthyear, int _birthmonth, int _birthday, int _symptomyear, int _symptommonth, int _symptomday,
                         int _arrivalyear, int _arrivalmonth, int _arrivalday, int _symptomhour, int _symptommin, int _arrivalhour, int _arrivalmin,
                         double _age, int _gender, int _pmhx, int _woke, int _wellweekb4,
                         int _medicaltransport, int _highcategory, int _vertigo, int _headace, int _vomit, int _dizziness, int _speechloss, int _focalnumb,
                         int _focalweek, int _seizure, int _mentalstate, int _loc, int _vision, int _ataxia, int _other, int _sudden, int _improving,
                         int _referred, int _phonophobia, int _photophobia) {

        this.studyid = _studyid;
        this.birthyear = _birthyear;
        this.birthmonth = _birthmonth;
        this.birthday = _birthday;
        this.symptomyear = _symptomyear;
        this.symptommonth = _symptommonth;
        this.symptomday = _symptomday;
        this.arrivalyear = _arrivalyear;
        this.arrivalmonth = _arrivalmonth;
        this.arrivalday = _arrivalday;
        this.symptomhour = _symptomhour;
        this.symptommin = _symptommin;
        this.arrivalhour = _arrivalhour;
        this.arrivalmin = _arrivalmin;
        this.age = _age;
        this.gender = _gender;
        this.pmhx = _pmhx;
        this.woke = _woke;
        this.wellweekb4 = _wellweekb4;
        this.medicaltransport = _medicaltransport;
        this.highcategory = _highcategory;
        this.vertigo = _vertigo;
        this.headace = _headace;
        this.vomit = _vomit;
        this.dizziness = _dizziness;
        this.speechloss = _speechloss;
        this.focalnumb = _focalnumb;
        this.focalweek = _focalweek;
        this.seizure = _seizure;
        this.mentalstate = _mentalstate;
        this.loc = _loc;
        this.vision = _vision;
        this.ataxia = _ataxia;
        this.other = _other;
        this.sudden = _sudden;
        this.improving = _improving;
        this.referred = _referred;
        this.phonophobia = _phonophobia;
        this.photophobia = _photophobia;
    }

    public void setStudyid(int _studyid) {
        this.studyid = _studyid;
    }

    public int getStudyid() {
        return studyid;
    }

    public void setBirthyear(int _birthyear) {this.birthyear = _birthyear;}
    public int getBirthyear() {return birthyear;}

    public void setBirthmonth(int _birthmonth) {this.birthmonth = _birthmonth;}
    public int getBirthmonth() {return birthmonth;}

    public void setBirthday(int _birthday) {this.birthday = _birthday; }
    public int getBirthday() {return birthday;}

    public void setSymptomyear(int _symptomyear) {this.symptomyear = _symptomyear;}
    public int getSymptomyear() {return symptomyear;}

    public void setSymptommonth(int _symptommonth) {this.symptommonth = _symptommonth;}
    public int getSymptommonth() {return symptommonth;}

    public void setSymptomday(int _symptomday) {this.symptomday = _symptomday;}
    public int getSymptomday() {return symptomday;}

    public void setArrivalyear(int _arrivalyear) {this.arrivalyear = _arrivalyear;}
    public int getArrivalyear() {return arrivalyear;}

    public void setArrivalmonth(int _arrivalmonth) {this.arrivalmonth = _arrivalmonth;}
    public int getArrivalmonth() {return arrivalmonth;}

    public void setArrivalday(int _arrivalday) {this.arrivalday = _arrivalday;}
    public int getArrivalday() {return arrivalday;}

    public void setSymptomhour(int _symptomhour){this.symptomhour = _symptomhour;}
    public int getSymptomhour(){return symptomhour;}

    public void setSymptommin(int _symptommin){this.symptommin = _symptommin;}
    public int getSymptommin(){return  symptommin;}

    public void setArrivalhour(int _arrivalhour){this.arrivalhour = _arrivalhour;}
    public int getArrivalhour(){return arrivalhour;}

    public void setArrivalmin(int _arrivalmin){this.arrivalmin = _arrivalmin;}
    public int getArrivalmin(){return arrivalmin;}

    public void setAge(double _age) {
        this.age = _age;
    }

    public double getAge() {
        return age;
    }

    public void setGender(int _gender) {
        this.gender = _gender;
    }

    public int getGender() {
        return gender;
    }

    public void setPmhx(int _pmhx) {
        this.pmhx = _pmhx;
    }

    public int getPmhx() {
        return pmhx;
    }

    public void setWoke(int _woke) {
        this.woke = _woke;
    }

    public int getWoke() {
        return woke;
    }

    public void setWellweekb4(int _wellweekb4) {
        this.wellweekb4 = _wellweekb4;
    }

    public int getWellweekb4() {
        return wellweekb4;
    }

    public void setMedicaltransport(int _medicaltransport) {
        this.medicaltransport = _medicaltransport;
    }

    public int getMedicaltransport() {
        return medicaltransport;
    }

    public void setHighcategory(int _highcategory){this.highcategory = _highcategory;}
    public int getHighcategory(){return highcategory;}

    public void setVertigo(int _vertigo) {
        this.vertigo = _vertigo;
    }

    public int getVertigo() {
        return vertigo;
    }

    public void setHeadace(int _headace) {
        this.headace = _headace;
    }

    public int getHeadace() {
        return headace;
    }

    public void setVomit(int _vomit) {
        this.vomit = _vomit;
    }

    public int getVomit() {
        return vomit;
    }

    public void setDizziness(int _dizziness) {
        this.dizziness = _dizziness;
    }

    public int getDizziness() {
        return dizziness;
    }

    public void setSpeechloss(int _speechloss) {
        this.speechloss = _speechloss;
    }

    public int getSpeechloss() {
        return speechloss;
    }

    public void setFocalnumb(int _focalnumb) {
        this.focalnumb = _focalnumb;
    }

    public int getFocalnumb() {
        return focalnumb;
    }

    public void setFocalweek(int _focalweek) {
        this.focalweek = _focalweek;
    }

    public int getFocalweek() {
        return focalweek;
    }

    public void setSeizure(int _seizure) {
        this.seizure = _seizure;
    }

    public int getSeizure() {
        return seizure;
    }

    public void setMentalstate(int _mentalstate) {
        this.mentalstate = _mentalstate;
    }

    public int getMentalstate() {
        return mentalstate;
    }

    public void setLoc(int _loc) {
        this.loc = _loc;
    }

    public int getLoc() {
        return loc;
    }

    public void setVision(int _vision) {
        this.vision = _vision;
    }

    public int getVision() {
        return vision;
    }

    public void setAtaxia(int _ataxia) {
        this.ataxia = _ataxia;
    }

    public int getAtaxia() {
        return ataxia;
    }

    public void setOther(int _other) {
        this.other = _other;
    }

    public int getOther() {
        return other;
    }

    public void setSudden(int _sudden) {
        this.sudden = _sudden;
    }

    public int getSudden() {
        return sudden;
    }

    public void setImproving(int _improving) {
        this.improving = _improving;
    }

    public int getImproving() {
        return improving;
    }

    public void setReferred(int _referred) {
        this.referred = _referred;
    }

    public int getReferred() {
        return referred;
    }

    public void setPhonophobia(int _phonophobia){
        this.phonophobia = _phonophobia;
    }

    public int getPhonophobia(){return phonophobia;}

    public void setPhotophobia(int _photophobia){
        this.photophobia = _photophobia;
    }

    public int getPhotophobia(){return photophobia;}

}


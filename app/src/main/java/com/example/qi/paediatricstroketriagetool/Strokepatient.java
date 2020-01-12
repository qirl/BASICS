package com.example.qi.paediatricstroketriagetool;

public class Strokepatient {
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
    private int highcategory;
    private int photophobia;
    private int phonophobia;
    private int pupils;
    private int eyeresponse;
    private int verbalresponse;
    private int motorresponse;
    private int consciousness;
    private int LOCquestions;
    private int LOCcommands;
    private int bestgaze;
    private int visualfield;
    private int facialpalsy;
    private int leftarm;
    private int leftleg;
    private int rightleg;
    private int rightarm;
    private int weakhand;
    private int limbataxia;
    private int sensearm;
    private int senseleg;
    private int senseface;
    private int sensory;
    private int language;
    private int dysarghria;
    private int dysarthria;
    private int extinction;
    private int senseneg;
    private int walknotokcrf2;
    private int other2;

    public Strokepatient(){ }

    public Strokepatient(int _studyid, int _birthyear, int _birthmonth, int _birthday, int _symptomyear, int _symptommonth, int _symptomday,
                         int _arrivalyear, int _arrivalmonth, int _arrivalday,
                         int _symptomhour, int _symptommin, int _arrivalhour, int _arrivalmin, double _age, int _gender, int _pmhx, int _woke, int _wellweekb4,
                         int _medicaltransport, int _highcategory,
                         int _vertigo, int _headace, int _vomit, int _sudden, int _improving,int _dizziness, int _speechloss,
                         int _focalnumb, int _focalweek, int _seizure, int _mentalstate, int _loc, int _vision, int _ataxia,
                         int _other, int _referred,  int _photophobia, int _phonophobia, int _pupils,
                         int _eyeresponse, int _verbalresponse, int _motorresponse, int _consciousness, int _LOCquestions,
                         int _LOCcommands, int _bestgaze, int _visualfield, int _facialpalsy, int _leftarm, int _leftleg,
                         int _rightleg, int _rightarm, int _weakhand, int _limbataxia, int _sensearm, int _senseleg,
                         int _senseface, int _sensory, int _language, int _dysarghria, int _dysarthria, int _extinction,
                         int _senseneg, int _walknotokcrf2, int _other2){

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
        this.photophobia = _photophobia;
        this.phonophobia = _phonophobia;
        this.pupils = _pupils;
        this.eyeresponse = _eyeresponse;
        this.verbalresponse = _verbalresponse;
        this.motorresponse = _motorresponse;
        this.consciousness = _consciousness;
        this.LOCquestions = _LOCquestions;
        this.LOCcommands = _LOCcommands;
        this.bestgaze = _bestgaze;
        this.visualfield = _visualfield;
        this.facialpalsy = _facialpalsy;
        this.leftarm = _leftarm;
        this.leftleg = _leftleg;
        this.rightleg = _rightleg;
        this.rightarm = _rightarm;
        this.weakhand = _weakhand;
        this.limbataxia = _limbataxia;
        this.sensearm = _sensearm;
        this.senseleg = _senseleg;
        this.senseface = _senseface;
        this.sensory = _sensory;
        this.language = _language;
        this.dysarghria = _dysarghria;
        this.dysarthria = _dysarthria;
        this.extinction = _extinction;
        this.senseneg = _senseneg;
        this.walknotokcrf2 = _walknotokcrf2;
        this.other2 = _other2;
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

    public void setWellweekb4(int _wellweekb4){ this.wellweekb4 = _wellweekb4; }
    public int getWellweekb4() {
        return wellweekb4;
    }

    public void setMedicaltransport(int _medicaltransport) { this.medicaltransport = _medicaltransport;}
    public int getMedicaltransport() {
        return medicaltransport;
    }

    public void setHighcategory(int _highcategory) {
        this.highcategory = _highcategory;
    }

    public int getHighcategory() {
        return highcategory;
    }

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

    public void setPhotophobia(int _photophobia) {
        this.photophobia = _photophobia;
    }

    public int getPhotophobia() {
        return photophobia;
    }

    public void setPhonophobia(int _phononophobia) {
        this.phonophobia = _phononophobia;
    }

    public int getPhonophobia() {
        return phonophobia;
    }

    public void setPupils(int _pupils) {
        this.pupils = _pupils;
    }

    public int getPupils() {
        return pupils;
    }

    public void setEyeresponse(int _eyeresponse) {
        this.eyeresponse = _eyeresponse;
    }

    public int getEyeresponse() {
        return eyeresponse;
    }

    public void setVerbalresponse(int _verbalresponse) {
        this.verbalresponse = _verbalresponse;
    }

    public int getVerbalresponse() {
        return verbalresponse;
    }

    public void setMotorresponse(int _motorresponse) {
        this.motorresponse = _motorresponse;
    }

    public int getMotorresponse() {
        return motorresponse;
    }

    public void setConsciousness(int _consciousness) {
        this.consciousness = _consciousness;
    }

    public int getConsciousness() {
        return consciousness;
    }

    public void setLOCquestions(int _LOCquestions) {
        this.LOCquestions = _LOCquestions;
    }

    public int getLOCquestions() {
        return LOCquestions;
    }

    public void setLOCcommands(int _LOCcommands) {
        this.LOCcommands = _LOCcommands;
    }

    public int getLOCcommands() {
        return LOCcommands;
    }

    public void setBestgaze(int _bestgaze) {
        this.bestgaze = _bestgaze;
    }

    public int getBestgaze() {
        return bestgaze;
    }

    public void setVisualfield(int _visualfield) {
        this.visualfield = _visualfield;
    }

    public int getVisualfield() {
        return visualfield;
    }

    public void setFacialpalsy(int _facialpalsy){
        this.facialpalsy = _facialpalsy;
    }

    public int getFacialpalsy(){
        return facialpalsy;
    }

    public void setLeftarm(int _leftarm){
        this.leftarm = _leftarm;
    }

    public int getLeftarm(){
        return  leftarm;
    }

    public void setLeftleg(int _leftleg){
        this.leftleg = _leftleg;
    }

    public int getLeftleg(){
        return  leftleg;
    }

    public void setRightleg(int _rightleg){
        this.rightleg = _rightleg;
    }

    public int getRightleg(){
        return rightleg;
    }

    public void setRightarm(int _rightarm){
        this.rightarm = _rightarm;
    }

    public int getRightarm(){
        return rightarm;
    }

    public void setWeakhand(int _weakhand){
        this.weakhand = _weakhand;
    }

    public int getWeakhand(){
        return weakhand;
    }

    public void setLimbataxia(int _limbataxia){
        this.limbataxia = _limbataxia;
    }

    public int getLimbataxia(){
        return limbataxia;
    }

    public void setSensearm(int _sensearm){
        this.sensearm = _sensearm;
    }

    public int getSensearm(){
        return sensearm;
    }

    public void setSenseleg(int _senseleg){
        this.senseleg = _senseleg;
    }

    public int getSenseleg(){
        return senseleg;
    }

    public void setSenseface(int _senseface){
        this.senseface = _senseface;
    }

    public int getSenseface(){
        return senseface;
    }

    public void setSensory(int _sensory){
        this.sensory = _sensory;
    }

    public int getSensory(){
        return  sensory;
    }

    public void setLanguage(int _language){
        this.language = _language;
    }

    public int getLanguage(){
        return language;
    }

    public void setDysarghria(int _dysarghria){this.dysarghria = _dysarghria;}
    public int getDysarghria(){return dysarghria;}

    public void setDysarthria(int _dysarthria){
        this.dysarthria = _dysarthria;
    }

    public int getDysarthria(){
        return dysarthria;
    }

    public void setExtinction(int _extinction){
        this.extinction = _extinction;
    }

    public int getExtinction(){
        return  extinction;
    }

    public void setSenseneg(int _senseneg){
        this.senseneg = _senseneg;
    }

    public int getSenseneg(){
        return senseneg;
    }

    public void setWalknotokcrf2(int _walknotokcrf2){
        this.walknotokcrf2 = _walknotokcrf2;
    }

    public int getWalknotokcrf2(){
        return walknotokcrf2;
    }

    public void setOther2(int _other2){
        this.other2 = _other2;
    }

    public int getOther2(){
        return other2;
    }
}










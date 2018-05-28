package org.darkbyte.classnotes;



import java.util.Arrays;
import java.util.List;

public class DepartmentDataFactory {

  public static List<Department> makeDepartments() {
    return Arrays.asList(makeCSEDepartment(),
        makeECEDepartment(),
        makeEEEDepartment(),
        makeMechanicalDepartment(),
        makeChemicalDepartment());
  }

  

  public static Department makeCSEDepartment() {
    return new Department("CSE", makeCSESemesters(), R.drawable.notepad);
  }


  public static List<Semester> makeCSESemesters() {
    Semester First = new Semester("First", true);
    Semester Second = new Semester("Second", false);
    Semester Third = new Semester("Third", false);
    Semester Fourth = new Semester("Fourth", true);
    Semester Fifth = new Semester("Fifth", true);
    Semester Sixth = new Semester("Sixth", false);
    Semester Seventh = new Semester("Seventh", false);
    Semester Eigth = new Semester("Eigth", true);

    return Arrays.asList(First, Second, Third, Fourth,Fifth,Sixth,Seventh,Eigth);
  }

  public static Department makeECEDepartment() {
    return new Department("ECE", makeECESemesters(), R.drawable.notepad);
  }



  public static List<Semester> makeECESemesters() {
    Semester First = new Semester("First", true);
    Semester Second = new Semester("Second", false);
    Semester Third = new Semester("Third", false);
    Semester Fourth = new Semester("Fourth", true);
    Semester Fifth = new Semester("Fifth", true);
    Semester Sixth = new Semester("Sixth", false);
    Semester Seventh = new Semester("Seventh", false);
    Semester Eigth = new Semester("Eigth", true);

    return Arrays.asList(First, Second, Third, Fourth,Fifth,Sixth,Seventh,Eigth);
  }

  public static Department makeEEEDepartment() {
    return new Department("EEE", makeEEESemesters(), R.drawable.notepad);
  }



  public static List<Semester> makeEEESemesters() {
    Semester First = new Semester("First", true);
    Semester Second = new Semester("Second", false);
    Semester Third = new Semester("Third", false);
    Semester Fourth = new Semester("Fourth", true);
    Semester Fifth = new Semester("Fifth", true);
    Semester Sixth = new Semester("Sixth", false);
    Semester Seventh = new Semester("Seventh", false);
    Semester Eigth = new Semester("Eigth", true);

    return Arrays.asList(First, Second, Third, Fourth,Fifth,Sixth,Seventh,Eigth);
  }

  public static Department makeMechanicalDepartment() {
    return new Department("Mechanical", makemechSemesters(), R.drawable.notepad);
  }



  public static List<Semester> makemechSemesters() {
    Semester First = new Semester("First", true);
    Semester Second = new Semester("Second", false);
    Semester Third = new Semester("Third", false);
    Semester Fourth = new Semester("Fourth", true);
    Semester Fifth = new Semester("Fifth", true);
    Semester Sixth = new Semester("Sixth", false);
    Semester Seventh = new Semester("Seventh", false);
    Semester Eigth = new Semester("Eigth", true);


    return Arrays.asList(First, Second, Third, Fourth,Fifth,Sixth,Seventh,Eigth);
  }

  public static Department makeChemicalDepartment() {
    return new Department("Chemical", makeChemicalSemesters(), R.drawable.notepad);
  }


  public static List<Semester> makeChemicalSemesters() {
    Semester First = new Semester("First", true);
    Semester Second = new Semester("Second", false);
    Semester Third = new Semester("Third", false);
    Semester Fourth = new Semester("Fourth", true);
    Semester Fifth = new Semester("Fifth", true);
    Semester Sixth = new Semester("Sixth", false);
    Semester Seventh = new Semester("Seventh", false);
    Semester Eigth = new Semester("Eigth", true);


    return Arrays.asList(First, Second, Third, Fourth,Fifth,Sixth,Seventh,Eigth);
  }

}


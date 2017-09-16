import java.util.Date;
import java.util.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation
{

    private Student[] students;
    List<Student> list = Arrays.asList(students);
    /**
     * DO NOT remove or change this constructor, it will be used during task check
     * @param length
     */
    public StudentGroup(int length)
    {
        this.students = new Student[length];
    }

    @Override
    public Student[] getStudents()
    {
        // Add your implementation here
        return students;
    }

    @Override
    public void setStudents(Student[] students)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            List<Student> list1 = Arrays.asList(students);
            list.addAll(list1);
            // Add your implementation here
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public Student getStudent(int index)
    {
        // Add your implementation here
        try
        {
            if(index<0||index>=students.length)
                throw new Exception("IllegalArgumentException");
            return this.students[index];

            // Add your implementation here
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public void setStudent(Student student, int index)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            list.set(index,new Student(student));
            // Add your implementation here
        }
        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void addFirst(Student student)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            Collections.reverse(list);
            list.add(new Student(student));
            Collections.reverse(list);		// Add your implementation here
        }
        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void addLast(Student student)
    {
        // Add your implementation here
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            list.add(new Student(student));
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void add(Student student, int index)
    {
        // Add your implementation here
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            list.set(index,new Student(student));
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void remove(int index)
    {
        try
        {
            if(index<0||index>=students.length)
                throw new Exception("IllegalArgumentException");
            //return this.students[index];
            list.remove(index);

            // Add your implementation here
        }
        catch(Exception e)
        {
            //return null;
        }
        // Add your implementation here
    }

    @Override
    public void remove(Student student)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            for(int i=0; i<students.length; i++)
                if(students[i].equals(student))
                {
                    list.remove(i);
                    break;
                }

        }
        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void removeFromIndex(int index)
    {
        try
        {
            if(index<0||index>=students.length)
                throw new Exception("IllegalArgumentException");
            for(int i=index; i<students.length; i++)
                list.remove(i);
        }

        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void removeFromElement(Student student)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            for(int i=0; i<students.length; i++)
                if(students[i].equals(student))
                {
                    list.remove(i);
                    for(int j=i; j<students.length; j++)
                        list.remove(j);
                }

        }
        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void removeToIndex(int index)
    {
        try
        {
            if(index<0||index>=students.length)
                throw new Exception("IllegalArgumentException");
            for(int i=0; i<index; i++)
                list.remove(i);
        }

        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void removeToElement(Student student)
    {
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            int flag=0;
            for(int i=0; i<students.length; i++)
            {
                if(students[i].equals(student))
                {
                    // list.remove(i);
                    flag=1;
                    break;
                }


            }
            if(flag==1)
                for(int i=0; i<students.length; i++)
                {
                    if(!students[i].equals(student))
                    {
                        list.remove(i);
                    }
                    else
                        break;

                }
        }
        catch(Exception e)
        {

        }
        // Add your implementation here
    }

    @Override
    public void bubbleSort()
    {
        // Add your implementation here
        int n = students.length;
        Student temp;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(students[j-1].getId() > students[j].getId())
                {
                    //swap elements
                    temp = students[j-1];
                    students[j-1] = students[j];
                    students[j] = temp;
                }

            }
        }
    }

    @Override
    public Student[] getByBirthDate(Date date)
    {
        // Add your implementation here
        try
        {
            if(date==null)
                throw new Exception("IllegalArgumentException");
            int count = 0;
            for(int i=0; i<students.length; i++)
                if(students[i].getBirthDate().equals(date) || students[i].getBirthDate().before(date))
                    count++;
            Student temp[] = new Student[count];
            count = 0;
            for(int i=0; i<students.length; i++)
                if(students[i].getBirthDate().equals(date) || students[i].getBirthDate().before(date))
                    temp[count++] = new Student(students[i]);
            return temp;

        }
        catch(Exception e)
        {
            return null;

        }
    }

    @Override
    public Student[] getBetweenBirthDates(Date firstDate, Date lastDate)
    {
        try
        {
            if(firstDate==null || lastDate==null)
                throw new Exception("IllegalArgumentException");
            int count = 0;
            for(int i=0; i<students.length; i++)
                if((students[i].getBirthDate().after(firstDate)||students[i].getBirthDate().equals(firstDate)) && (students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().equals(lastDate)))
                    count++;
            Student temp[] = new Student[count];
            count = 0;
            for(int i=0; i<students.length; i++)
                if((students[i].getBirthDate().after(firstDate)||students[i].getBirthDate().equals(firstDate)) && (students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().equals(lastDate)))
                    temp[count++] = new Student(students[i]);
            return temp;

        }
        catch(Exception e)
        {
            return null;

        }
    }
    @Override
    public Student[] getNearBirthDate(Date date, int days)
    {
        // Add your implementation here

        return null;
    }

    @Override
    public int getCurrentAgeByDate(int indexOfStudent)
    {
        // Add your implementation here
        return 0;
    }

    @Override
    public Student[] getStudentsByAge(int age)
    {
        // Add your implementation here
        return null;
    }

    @Override
    public Student[] getStudentsWithMaxAvgMark()
    {
        // double max = -1;
        double max = -1;
        for(int i=0; i<students.length; i++)
            if(max < students[i].getAvgMark())
                max = students[i].getAvgMark();

        int count = 0;
        for(int i=0; i<students.length; i++)
            if(max == students[i].getAvgMark())
                count++;
        Student temp[] = new Student[count];
        count = 0;
        for(int i=0; i<students.length; i++)
            if(max == students[i].getAvgMark())
                temp[count++] = new Student(students[i]);
        return temp;


        // Add your implementation here
    }

    @Override
    public Student getNextStudent(Student student)
    {
        int i=0;
        try
        {
            if(students==null)
                throw new Exception("IllegalArgumentException");
            for(i=0; i<students.length; i++)
                if(students[i].equals(student))
                {
                    break;
                }
return students[i+1];
        }
        catch(Exception e)
        {
            return null;
        }
    }
}

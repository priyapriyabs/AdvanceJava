package com.priyanka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.priyanka.core.AllStudent;
import com.priyanka.core.Book;
import com.priyanka.core.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext apx=new AnnotationConfigApplicationContext(AllStudent.class);
        apx.getBean(Student.class).getBook();
        apx.getBean(Book.class).getMyBook();
    }
}

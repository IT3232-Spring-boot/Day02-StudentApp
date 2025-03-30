package lk.uov.fas.ict.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.uov.fas.ict.backend.model.StudentModel;




@RestController
@RequestMapping("/api-student")
public class StudentController {

    StudentModel s1 = new StudentModel("2020-ict-01", "mini", 25, "ict");
    StudentModel s2 = new StudentModel("2020-ict-02", "thira", 25, "ict");
    StudentModel s3 = new StudentModel("2020-ict-03", "bandara", 26, "ict");

    List<StudentModel> stuArray = new ArrayList<>();

    @GetMapping("/add-all")
    public List<StudentModel> setAllStudent() {
        stuArray.add(s1);
        stuArray.add(s2);
        stuArray.add(s3);

        return stuArray;
    }

    @GetMapping("/filter-by/{regNu}")
    public StudentModel filterByRegNu(@PathVariable("regNu") String regNu) {
        for(int i = 0; i < stuArray.size(); i++) {
            if(stuArray.get(i).getRegNu().equals(regNu)) {
                System.out.print(stuArray.get(i));
                return stuArray.get(i);
            }
        }
        return null;
    }
    
}

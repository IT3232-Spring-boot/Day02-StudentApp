package lk.uov.fas.ict.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.uov.fas.ict.backend.model.StudentModel;

import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api-student")
public class StudentController {

    StudentModel s1 = new StudentModel("2020-ict-01", "mini", 25, "ict");
    StudentModel s2 = new StudentModel("2020-ict-02", "thira", 25, "ict");
    StudentModel s3 = new StudentModel("2020-ict-03", "bandara", 26, "ict");

    // List<StudentModel> stuArray = new ArrayList<>();
    //Impliment Mapping strucure for efficient data storage and retrival
    Map<String, StudentModel> studentStructure = new HashMap<>();

    public StudentController() {
        studentStructure.put(s1.getRegNu(), s1);
        studentStructure.put(s2.getRegNu(), s2);
        studentStructure.put(s3.getRegNu(), s3);
    }

    // @GetMapping("/add-all")
    // public List<StudentModel> setAllStudent() {
    //     stuArray.add(s1);
    //     stuArray.add(s2);
    //     stuArray.add(s3);

    //     return stuArray;
    // }

    @GetMapping("all-stu")
    public Map<String, StudentModel> getAllStu() {
        return studentStructure;
    }

    @GetMapping("filter-by-regNo/{regNo}")
    public ResponseEntity<?> getMethodName(@PathVariable("regNo") String regNo) {
        StudentModel response = studentStructure.get(regNo);
        if(response != null) {
            return ResponseEntity.ok(response);
        } 
        else {
            // ErrorResponse error = new ErrorResponse("User Not Found " + regNo); Need error response class this is a abstract one
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found " + regNo);
        }
    }
    
    

    // @GetMapping("/filter-by/{regNu}")
    // public StudentModel filterByRegNu(@PathVariable("regNu") String regNu) {
    //     for(int i = 0; i < stuArray.size(); i++) {
    //         if(stuArray.get(i).getRegNu().equals(regNu)) {
    //             System.out.print(stuArray.get(i));
    //             return stuArray.get(i);
    //         }
    //     }
    //     return null;
    // }
    
}

import Entity.Course;
import Entity.Department;
import Entity.Student;
import RepositoryImplementation.CourseRepositoryImplementation;
import RepositoryImplementation.DepartmentRepositoryImplementation;
import RepositoryImplementation.StudentCourseRepositoryImplementation;
import RepositoryImplementation.StudentRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        DepartmentRepositoryImplementation departmentRepositoryImplementation
                = applicationContext.getBean("departmentRepositoryImplementation", DepartmentRepositoryImplementation.class);

        CourseRepositoryImplementation courseRepositoryImplementation
                = applicationContext.getBean("courseRepositoryImplementation", CourseRepositoryImplementation.class);

        StudentRepositoryImplementation studentRepositoryImplementation
                = applicationContext.getBean("studentRepositoryImplementation", StudentRepositoryImplementation.class);

        StudentCourseRepositoryImplementation studentCourseRepositoryImplementation
                = applicationContext.getBean("studentCourseRepositoryImplementation", StudentCourseRepositoryImplementation.class);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean runApplication = true;

        while(runApplication){

            System.out.println("==================Welcome to College Record=================");
            System.out.println("\n");

            List<Department> departments = departmentRepositoryImplementation.getAllDepartments();
            System.out.println("Total Departments : " + departments.size());

            List<Course>courses = courseRepositoryImplementation.getAllCourses();
            System.out.println("Total Courses : " + courses.size());

            List<Student>students = studentRepositoryImplementation.getAllStudents();
            System.out.println("Total Students : " + students.size());

            System.out.println("\n");
            System.out.println("=================Options=================");

            System.out.println("\n1. View all Departments  " +
                    "2. View a Department  " +
                    "3. Add new Department  " +
                    "4. Update a Department  " +
                    "5. Delete a Department  " +
                    "\n\n6. View all Courses  " +
                    "7. View a Course  " +
                    "8. Add new Course  " +
                    "9. Update a Course  " +
                    "10. Delete a Course  " +
                    "\n\n11. View all Students  " +
                    "12. View a Student  " +
                    "13. Add new Student  " +
                    "14. Update a Student  " +
                    "15. Delete a Student  " +
                    "\n\n16. Exit");

            System.out.println("\n=================Your Choice=================");
            System.out.println("\nYour Choice: ");

            try {
                int choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){

                    //Department
                    //view all departments
                    System.out.println("-----------------------------------------------------------------------------------");

                    case 1:
                        for(int i = 0; i < departments.size(); i++){
                            System.out.println(departments.get(i).getDepartmentId() + " " + departments.get(i).getDepartmentName());
                        }
                        System.out.println("\n");
                        break;

                    //view a Department
                    case 2:
                        System.out.println("Enter Department Id: ");
                        int departmentChoice = Integer.parseInt(bufferedReader.readLine());

                        Department department = departmentRepositoryImplementation.getDepartment(departmentChoice);
                        System.out.println(department.getDepartmentId() + " " + department.getDepartmentName());
                        System.out.println("\n");
                        break;

                    //add a new Department
                    case 3:
                        System.out.println("Enter Department Id: ");
                        int departmentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Department Name: ");
                        String departmentName = bufferedReader.readLine();

                        Department departmentNew = new Department(departmentId, departmentName);
                        departmentRepositoryImplementation.insertDepartment(departmentNew);
                        System.out.println("New Department Inserted");
                        System.out.println("\n");
                        break;

                    //update a Department
                    case 4:
                        System.out.println("Enter Department Id: ");
                        int updateDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Department Name: ");
                        String updateDepartmentName = bufferedReader.readLine();

                        Department updateDepartment = new Department(updateDepartmentId, updateDepartmentName);
                        departmentRepositoryImplementation.updateDepartment(updateDepartment);
                        System.out.println("Updated Department");
                        System.out.println("\n");
                        break;

                    //delete a Department
                    case 5:
                        System.out.println("Enter Department Id: ");
                        int deleteDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        departmentRepositoryImplementation.deleteDepartment(deleteDepartmentId);
                        System.out.println("Department Deleted");
                        System.out.println("\n");
                        break;

                    //Courses
                    //view all Courses
                    case 6:
                        for(int i = 0; i < courses.size(); i++){
                            Department allCourseDepartments = departmentRepositoryImplementation.getDepartment(courses.get(i).getDepartment().getDepartmentId());
                            String allCoursesDepartmentName = allCourseDepartments.getDepartmentName();
                            System.out.println(brands.get(i).getBrandId() +
                                    " | " +
                                    brands.get(i).getBrandName() +
                                    " | Category : " + allBrandCategoryName);

                        }
                        System.out.println("\n");
                        break;

                    //view a particular brand
                    case 7:
                        System.out.println("Enter Brand Id: ");
                        int brandId = Integer.parseInt(bufferedReader.readLine());

                        Brand brand = brandRepositoryImplementation.getBrand(brandId);
                        Category brandCategory = categoryRepositoryImplementation.getCategory(brand.getCategory_id());
                        String brandCategoryName = brandCategory.getCategoryName();
                        System.out.println(brand.getBrandId() +
                                " | " +
                                brand.getBrandName() +
                                " | " +
                                "Category : " + brandCategoryName);
                        System.out.println("\n");
                        break;

                    //add a new brand
                    case 8:
                        System.out.println("Enter Brand Id: ");
                        int newBrandId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Brand Name: ");
                        String newBrandName = bufferedReader.readLine();

                        System.out.println("Enter Category Id: ");
                        int brandCategoryId = Integer.parseInt(bufferedReader.readLine());

                        Brand brandNew = new Brand(newBrandId, newBrandName, brandCategoryId);
                        int brandInsertResult = brandRepositoryImplementation.insertBrand(brandNew);
                        System.out.println("New Brand Inserted with id = " + brandInsertResult);

                        System.out.println("\n");
                        break;

                    //update a new brand
                    case 9:
                        System.out.println("Enter Brand Id: ");
                        int updateBrandId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Brand Name: ");
                        String updateBrandName = bufferedReader.readLine();

                        System.out.println("Enter Category Id: ");
                        int updateBrandCategoryId = Integer.parseInt(bufferedReader.readLine());

                        Brand brandUpdate = new Brand(updateBrandId, updateBrandName, updateBrandCategoryId);
                        int brandUpdateResult = brandRepositoryImplementation.updateBrand(brandUpdate);
                        System.out.println("Brand updated with id = " + brandUpdateResult);

                        System.out.println("\n");
                        break;

                    // delete a brand
                    case 10:
                        System.out.println("Enter Brand Id: ");
                        int brandDeleteId = Integer.parseInt(bufferedReader.readLine());

                        int deleteBrandResult = brandRepositoryImplementation.deleteBrand(brandDeleteId);
                        System.out.println("Deleted category with id = " + deleteBrandResult);

                        System.out.println("\n");
                        break;

                    //Product
                    //view all products
                    case 11:
                        for(int i = 0; i < products.size(); i++){
                            Category productCategory = categoryRepositoryImplementation.getCategory(products.get(i).getCategoryId());
                            String allProductCategoryName = productCategory.getCategoryName();
                            Brand productBrand = brandRepositoryImplementation.getBrand(products.get(i).getBrandId());
                            String allProductBrandName = productBrand.getBrandName();
                            System.out.println(products.get(i).getProductId() +
                                    " " + products.get(i).getProductName() +
                                    " | Price : " + products.get(i).getProductPrice() +
                                    " | Category : " + allProductCategoryName +
                                    " | Brand : " + allProductBrandName);
                        }
                        System.out.println("\n");
                        break;

                    //view a product
                    case 12:
                        System.out.println("Enter Product Id: ");
                        int productId = Integer.parseInt(bufferedReader.readLine());

                        Product product = productRepositoryImplementation.getProduct(productId);
                        Brand productBrand = brandRepositoryImplementation.getBrand(product.getBrandId());
                        Category productCategory = categoryRepositoryImplementation.getCategory(product.getCategoryId());
                        String productCategoryName = productCategory.getCategoryName();
                        String productBrandName = productBrand.getBrandName();
                        System.out.println(product.getProductId() +
                                " " + product.getProductName() +
                                " | Price : " + product.getProductPrice() +
                                " | Category : " + productCategoryName +
                                " | Brand : " + productBrandName);

                        System.out.println("\n");
                        break;

                    //add a new product
                    case 13:
                        System.out.println("Enter Product Id: ");
                        int newProductId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Name: ");
                        String newProductName = bufferedReader.readLine();

                        System.out.println("Enter Product Price: ");
                        int newProductPrice = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Category Id: ");
                        int newProductCategoryId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Brand Id: ");
                        int newProductBrandId = Integer.parseInt(bufferedReader.readLine());

                        Product productNew = new Product(newProductId,
                                newProductName,
                                newProductPrice,
                                newProductCategoryId,
                                newProductBrandId);
                        int insertProductResult = productRepositoryImplementation.insertProduct(productNew);
                        System.out.println("New Product Inserted with id = " + insertProductResult);

                        System.out.println("\n");
                        break;

                    //update a new product
                    case 14:
                        System.out.println("Enter Product Id: ");
                        int updateProductId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Name: ");
                        String updateProductName = bufferedReader.readLine();

                        System.out.println("Enter Product Price: ");
                        int updateProductPrice = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Category Id: ");
                        int updateProductCategoryId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Brand Id: ");
                        int updateProductBrandId = Integer.parseInt(bufferedReader.readLine());

                        Product productUpdate = new Product(updateProductId,
                                updateProductName,
                                updateProductPrice,
                                updateProductCategoryId,
                                updateProductBrandId);
                        int productUpdateResult = productRepositoryImplementation.updateProduct(productUpdate);
                        System.out.println("Brand updated with id = " + productUpdateResult);

                        System.out.println("\n");
                        break;

                    //delete a product
                    case 15:
                        System.out.println("Enter Product Id: ");
                        int productDeleteId = Integer.parseInt(bufferedReader.readLine());

                        int deleteProductResult = productRepositoryImplementation.deleteProduct(productDeleteId);
                        System.out.println("Deleted Product with id = " + deleteProductResult);

                        System.out.println("\n");
                        break;

                    case 16:
                        runApplication = false;
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

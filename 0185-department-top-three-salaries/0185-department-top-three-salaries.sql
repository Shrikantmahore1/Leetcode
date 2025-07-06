# Write your MySQL query statement below

# Write your MySQL query statement below
with cte as
(select d.name department_name,e.name employee_name,e.salary,d.id,dense_rank() over(partition by departmentId order by salary desc) rnk
from Employee e
left join Department d
on e.departmentId=d.id

)


select department_name as Department, employee_name as Employee, salary as Salary from cte 
where rnk<=3
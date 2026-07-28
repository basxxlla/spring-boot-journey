/* ============================================================
   Filter JOB_HISTORY and DEPARTMENTS using SUBQUERIES (IN operator)
   ============================================================ */

-- Option 1: Retrieve matching JOB_HISTORY records
SELECT *
FROM job_history
WHERE job_id IN (
    SELECT job_id 
    FROM jobs 
    WHERE job_id IN (
        'AD_ASST', 'FI_MGR', 'FI_ACCOUNT', 
        'AC_MGR', 'AC_ACCOUNT', 'SA_MAN', 
        'SA_REP', 'PU_MAN'
    )
);


-- Option 2: Retrieve matching DEPARTMENTS records
SELECT *
FROM departments
WHERE department_name IN (
    SELECT department_name 
    FROM departments 
    WHERE department_name IN (
        'Administration', 'Marketing', 
        'Purchasing', 'Human Resources', 'Shipping'
    )
);


-- Option 3: Join both tables while filtering each using SUBQUERIES
SELECT 
    jh.employee_id, 
    jh.start_date, 
    jh.end_date, 
    jh.job_id, 
    d.department_name
FROM (
    SELECT * 
    FROM job_history 
    WHERE job_id IN (
        'AD_ASST', 'FI_MGR', 'FI_ACCOUNT', 
        'AC_MGR', 'AC_ACCOUNT', 'SA_MAN', 
        'SA_REP', 'PU_MAN'
    )
) jh
JOIN (
    SELECT * 
    FROM departments 
    WHERE department_name IN (
        'Administration', 'Marketing', 
        'Purchasing', 'Human Resources', 'Shipping'
    )
) d ON jh.department_id = d.department_id;
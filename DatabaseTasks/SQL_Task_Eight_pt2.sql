/* ============================================================
   1. NATURAL JOIN
   Implicitly joins on the shared column 'JOB_ID'.
   Note: Do NOT qualify JOB_ID with table aliases here.
   ============================================================ */
SELECT employee_id, start_date, end_date, job_id, job_title
FROM job_history
NATURAL JOIN jobs;


/* ============================================================
   2. JOIN ... USING
   Explicitly joins on 'JOB_ID'.
   Note: Do NOT qualify JOB_ID with table aliases when using USING.
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, job_id, j.job_title
FROM job_history jh
JOIN jobs j USING (job_id);


/* ============================================================
   3. JOIN ... ON
   Explicitly defines the matching condition on 'JOB_ID'.
   Note: MUST qualify job_id with table aliases (jh. / j.).
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, j.job_id, j.job_title
FROM job_history jh
JOIN jobs j ON jh.job_id = j.job_id;


/* ============================================================
   4. INNER JOIN
   Identical behavior to JOIN ... ON. Returns only historical records 
   that match an existing job definition.
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, j.job_id, j.job_title
FROM job_history jh
INNER JOIN jobs j ON jh.job_id = j.job_id;


/* ============================================================
   5. LEFT (OUTER) JOIN
   Returns ALL records from JOB_HISTORY, along with matching job titles.
   If a history record has no job match, job fields return NULL.
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, j.job_id, j.job_title
FROM job_history jh
LEFT JOIN jobs j ON jh.job_id = j.job_id;


/* ============================================================
   6. RIGHT (OUTER) JOIN
   Returns ALL jobs from JOBS, including jobs that have never been 
   held by an employee in the JOB_HISTORY table.
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, j.job_id, j.job_title
FROM job_history jh
RIGHT JOIN jobs j ON jh.job_id = j.job_id;


/* ============================================================
   7. FULL (OUTER) JOIN
   Combines LEFT and RIGHT joins. Returns all job history records 
   and all job titles, matching them where possible and filling NULLs.
   ============================================================ */
SELECT jh.employee_id, jh.start_date, jh.end_date, j.job_id, j.job_title
FROM job_history jh
FULL JOIN jobs j ON jh.job_id = j.job_id;
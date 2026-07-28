/* ============================================================
   1. NATURAL JOIN
   Implicitly joins on the shared column 'COUNTRY_ID'.
   Note: Do NOT qualify COUNTRY_ID with table aliases here.
   ============================================================ */
SELECT location_id, street_address, city, country_id, country_name
FROM locations
NATURAL JOIN countries;


/* ============================================================
   2. JOIN ... USING
   Explicitly joins on 'COUNTRY_ID'. 
   Note: Do NOT qualify COUNTRY_ID with table aliases when using USING.
   ============================================================ */
SELECT location_id, street_address, city, country_id, country_name
FROM locations
JOIN countries USING (country_id);


/* ============================================================
   3. JOIN ... ON
   Explicitly defines the matching condition. 
   Note: MUST qualify country_id with table aliases (l. / c.).
   ============================================================ */
SELECT l.location_id, l.street_address, l.city, c.country_id, c.country_name
FROM locations l
JOIN countries c ON l.country_id = c.country_id;


/* ============================================================
   4. INNER JOIN
   Identical behavior to JOIN ... ON. Returns only records 
   that have a match in both tables.
   ============================================================ */
SELECT l.location_id, l.street_address, l.city, c.country_id, c.country_name
FROM locations l
INNER JOIN countries c ON l.country_id = c.country_id;


/* ============================================================
   5. LEFT (OUTER) JOIN
   Returns ALL locations, plus matching country info. 
   If a location has no country match, country fields return NULL.
   ============================================================ */
SELECT l.location_id, l.street_address, l.city, c.country_id, c.country_name
FROM locations l
LEFT JOIN countries c ON l.country_id = c.country_id;


/* ============================================================
   6. RIGHT (OUTER) JOIN
   Returns ALL countries, plus matching location info. 
   Countries with no assigned locations will show NULL for location fields.
   ============================================================ */
SELECT l.location_id, l.street_address, l.city, c.country_id, c.country_name
FROM locations l
RIGHT JOIN countries c ON l.country_id = c.country_id;


/* ============================================================
   7. FULL (OUTER) JOIN
   Combines LEFT and RIGHT joins. Returns all locations and all 
   countries, matching them where possible and filling NULLs otherwise.
   ============================================================ */
SELECT l.location_id, l.street_address, l.city, c.country_id, c.country_name
FROM locations l
FULL JOIN countries c ON l.country_id = c.country_id;
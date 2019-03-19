--in parameters
CREATE OR REPLACE FUNCTION add_user(first_name varchar, last_name varchar)
  RETURNS void AS $$
BEGIN
  INSERT INTO users (first_name, last_name) VALUES (first_name, last_name);
END;
$$ LANGUAGE plpgsql;

--call
select add_user('Petr', 'Petrov');


--in and out parameters
create or replace function get_users(IN p_userId int, OUT p_first_name varchar, OUT p_last_name varchar)
  RETURNS record AS $$
BEGIN
  select first_name, last_name
         into p_first_name, p_last_name from users
  where user_id = p_userId;
END;
$$ LANGUAGE plpgsql;

--call
select get_users(1);




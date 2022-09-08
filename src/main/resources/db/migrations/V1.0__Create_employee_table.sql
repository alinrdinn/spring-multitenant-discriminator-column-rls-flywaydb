CREATE USER alinurdin WITH PASSWORD 'postgres';
            GRANT CONNECT ON DATABASE db_microservice TO alinurdin;
            ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES
                ON TABLES TO alinurdin;
            ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO alinurdin;
            ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT EXECUTE ON FUNCTIONS TO alinurdin;

GRANT USAGE ON SCHEMA public TO alinurdin;

CREATE TABLE IF NOT EXISTS employee
(
    tenant_id character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (username)
);

ALTER TABLE IF EXISTS employee
    ENABLE ROW LEVEL SECURITY;
-- POLICY: employee_tenant_isolation_policy

-- DROP POLICY IF EXISTS employee_tenant_isolation_policy ON public.employee;

CREATE POLICY employee_tenant_isolation_policy
    ON employee
    AS PERMISSIVE
    FOR ALL
    TO public
    USING (((tenant_id)::text = ((current_setting('app.tenant_id'::text))::character varying)::text));


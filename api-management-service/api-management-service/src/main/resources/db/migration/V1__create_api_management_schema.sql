CREATE TABLE organizations (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               name VARCHAR(150) NOT NULL UNIQUE,
                               slug VARCHAR(100) NOT NULL UNIQUE,
                               status VARCHAR(20) NOT NULL,
                               created_at DATETIME(6) NOT NULL,
                               updated_at DATETIME(6) NOT NULL,
                               deleted_at DATETIME(6)
);

CREATE TABLE roles (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE management_users (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  organization_id BIGINT UNIQUE,
                                  role_id BIGINT NOT NULL,
                                  username VARCHAR(100) NOT NULL UNIQUE,
                                  password_hash VARCHAR(255) NOT NULL,
                                  enabled BOOLEAN NOT NULL DEFAULT TRUE,
                                  created_at DATETIME(6) NOT NULL,
                                  updated_at DATETIME(6),

                                  FOREIGN KEY (organization_id) REFERENCES organizations(id),
                                  FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE api_routes (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            organization_id BIGINT NOT NULL,
                            route_id VARCHAR(100) NOT NULL,
                            name VARCHAR(200) NOT NULL,
                            path_pattern VARCHAR(500) NOT NULL,
                            target_base_url VARCHAR(1000) NOT NULL,
                            target_path_prefix VARCHAR(500) NOT NULL,
                            requests_per_minute INTEGER,
                            response_timeout_ms INTEGER NOT NULL,
                            idempotency_enabled BOOLEAN NOT NULL DEFAULT FALSE,
                            active BOOLEAN NOT NULL DEFAULT FALSE,
                            configuration_version BIGINT NOT NULL,
                            created_at DATETIME(6) NOT NULL,
                            updated_at DATETIME(6),

                            UNIQUE (organization_id, route_id),
                            FOREIGN KEY (organization_id) REFERENCES organizations(id)
);

CREATE TABLE route_allowed_methods (
                                       route_pk BIGINT NOT NULL,
                                       http_method VARCHAR(10) NOT NULL,

                                       PRIMARY KEY (route_pk, http_method),
                                       FOREIGN KEY (route_pk) REFERENCES api_routes(id) ON DELETE CASCADE
);

CREATE TABLE route_header_rules (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    route_pk BIGINT NOT NULL,
                                    direction VARCHAR(20) NOT NULL,
                                    action VARCHAR(20) NOT NULL,
                                    header_name VARCHAR(200) NOT NULL,
                                    header_value VARCHAR(2000),
                                    created_at DATETIME(6) NOT NULL,
                                    updated_at DATETIME(6) NOT NULL,

                                    FOREIGN KEY (route_pk) REFERENCES api_routes(id) ON DELETE CASCADE
);

CREATE TABLE route_configuration_versions (
                                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                              organization_id BIGINT NOT NULL,
                                              route_id VARCHAR(100) NOT NULL,
                                              version_number BIGINT NOT NULL,
                                              change_type VARCHAR(30) NOT NULL,
                                              configuration_snapshot LONGTEXT NOT NULL,
                                              created_at DATETIME(6) NOT NULL,

                                              UNIQUE (organization_id, route_id, version_number),
                                              FOREIGN KEY (organization_id) REFERENCES organizations(id)
);

CREATE TABLE control_plane_audit_records (
                                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                             organization_id BIGINT,
                                             actor VARCHAR(100) NOT NULL,
                                             action VARCHAR(100) NOT NULL,
                                             resource_type VARCHAR(100) NOT NULL,
                                             resource_id VARCHAR(100) NOT NULL,
                                             correlation_id VARCHAR(100),
                                             duration_ms BIGINT NOT NULL,
                                             result VARCHAR(20) NOT NULL,
                                             details VARCHAR(2000),
                                             created_at DATETIME(6) NOT NULL,

                                             FOREIGN KEY (organization_id) REFERENCES organizations(id)
);
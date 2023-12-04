
SET search_path to gymschema;

CREATE TABLE gyms (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    program VARCHAR(255) NOT NULL
);


CREATE TABLE classes (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    trainerName VARCHAR(255) NOT NULL,
    program VARCHAR(255) NOT NULL,
    gym_id UUID REFERENCES gyms(id) ON DELETE CASCADE
);


CREATE TABLE classes_subscription (
    classes_id UUID REFERENCES classes(id) ON DELETE CASCADE,
    subscription_id UUID REFERENCES subscription(id) ON DELETE CASCADE,
    PRIMARY KEY (classes_id, subscription_id)
);


CREATE TABLE members (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL
);

CREATE TABLE subscription (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    member_id UUID REFERENCES members(id) ON DELETE CASCADE
);

ALTER TABLE members
ADD COLUMN IF NOT EXISTS subscription_id UUID REFERENCES subscription(id) ON DELETE CASCADE;

CREATE TABLE classes_subscription (
    classes_id UUID REFERENCES classes(id) ON DELETE CASCADE,
    subscription_id UUID REFERENCES subscription(id) ON DELETE CASCADE,
    PRIMARY KEY (classes_id, subscription_id)
);
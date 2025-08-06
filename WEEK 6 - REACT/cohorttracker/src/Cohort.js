import React from 'react';  
import CohortDetails from './CohortDetails';
import styles from './Cohort.module.css';

class Cohort {
  constructor(cohortCode, startDate, technology, trainerName, coachName, currentStatus) {
    this.cohortCode = cohortCode;
    this.startDate = startDate;
    this.technology = technology;
    this.trainerName = trainerName;
    this.coachName = coachName;
    this.currentStatus = currentStatus;
  }
}

const cohorts = [
  new Cohort('INTADMDF10', '22-Feb-2022', '.NET FSD', 'Jojo Jose', 'Aathma', 'Scheduled'),
  new Cohort('ADM21JF014', '10-Sep-2021', 'Java FSD', 'Elisa Smith', 'Apoorv', 'Ongoing'),
  new Cohort('CDBJF21025', '24-Dec-2021', 'Java FSD', 'John Doe', 'Aathma', 'Ongoing'),
  new Cohort('INTADMJF12', '22-Feb-2022', 'Java FSD', 'To Be Assigned', 'Ibrahim', 'Scheduled'),
  new Cohort('CDE22JF011', '24-Dec-2021', 'Java FSD', 'Emma Swan', 'Apoorv', 'Ongoing'),
  new Cohort('INTADMDF09', '22-Feb-2022', 'Dataware Housing', 'Babjee Rao', 'Aathma', 'Scheduled'),
  new Cohort('ADM22DF001', '10-Sep-2021', '.NET FSD', 'Marie Curie', 'Ibrahim', 'Ongoing'),
];

const CohortComponent = () => {
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>Cohort List</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
};

export default CohortComponent;

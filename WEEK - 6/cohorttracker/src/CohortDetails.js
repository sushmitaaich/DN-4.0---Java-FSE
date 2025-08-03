import React from 'react';
import styles from './Cohort.module.css';

const CohortDetails = ({ cohort }) => {
  return (
    <div className={styles.card}>
      <h3>{cohort.cohortCode}</h3>
      <p><strong>Start Date:</strong> {cohort.startDate}</p>
      <p><strong>Technology:</strong> {cohort.technology}</p>
      <p><strong>Trainer:</strong> {cohort.trainerName}</p>
      <p><strong>Coach:</strong> {cohort.coachName}</p>
      <p><strong>Status:</strong> {cohort.currentStatus}</p>
    </div>
  );
};

export default CohortDetails;

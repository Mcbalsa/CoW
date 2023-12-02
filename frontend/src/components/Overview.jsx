import Box from '@mui/material/Box';
import Grid from '@mui/material/Unstable_Grid2';
import axios from "axios";
import React, { useEffect, useState } from "react";

function Overview() {
  const [school, setSchool] = useState({});

  // Will assume the first element is the college of Winterhold for now.
  const fetchData = async () => {
    await axios
      .get("http://localhost:8080/api/v1/School/GetAll")
      .then((data) => setSchool(data.data[0]))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchData();
  }, []);

  // ChatGPT

  return (
    <>

    <Box sx={{ flexGrow: 1}}>
    <Grid container spacing={2}>
      <Grid xs={5}>
      <div id="intro">
        <p>
          Greetings, budding mages, and welcome to the venerable {school.name},
          a sanctuary of magical learning amidst the rugged beauty of
          {school.province}. Founded by the legendary Archmage {school.founder}{" "}
          himself, this institution has stood the test of time, its walls
          steeped in the arcane lore that courses through our veins.{" "}
          {school.founder}, a master of countless spells and a scholar without
          peer, laid the foundation for this bastion of magical prowess,
          ensuring that the pursuit of knowledge would forever be etched into
          the very stones of our halls.
        </p>

        <p>
          As you step into these ancient chambers, you follow in the footsteps
          of the great wizards who have honed their craft here for centuries.
          The College is not merely a place of study; it is a crucible where
          your magical potential will be forged and tempered. Within these
          walls, the art of spellcasting becomes more than a mere practice – it
          becomes a way of life. The library, a treasure trove of arcane wisdom,
          holds tomes that {school.founder} himself may have perused, and it
          beckons you to unlock the mysteries that lie within.
        </p>

        <p>
          Under the watchful eye of the current Archmage, you will encounter a
          diverse community of scholars and fellow students, each driven by the
          pursuit of mastery over the arcane arts. As you navigate the
          challenges of {school.province}'s harsh landscape, remember that you
          are part of a lineage that extends back to the days when{" "}
          {school.founder} walked these very corridors. Embrace the frigid winds
          that whip through {school.city}, for they carry the whispers of
          ancient spells and the promise of untold power.
        </p>

        <p>
          In the shadow of {school.founder}'s legacy, you stand at the threshold
          of a journey that will shape not only your magical prowess but also
          your destiny. Welcome to the {school.name}, where the echoes of the
          past blend seamlessly with the enchanting possibilities of the future.
          May your time here be filled with discovery, enlightenment, and the
          unending pursuit of magical excellence.
        </p>
      </div>
      </Grid>
      <Grid xs={7}>
      <div>
        <img
          style={{ height: "619px", width: "1100px" }}
          src="https://private-user-images.githubusercontent.com/93947154/287460986-091990ae-175e-42aa-90cd-ae2171cc1cac.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE1MzQ4OTcsIm5iZiI6MTcwMTUzNDU5NywicGF0aCI6Ii85Mzk0NzE1NC8yODc0NjA5ODYtMDkxOTkwYWUtMTc1ZS00MmFhLTkwY2QtYWUyMTcxY2MxY2FjLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFJV05KWUFYNENTVkVINTNBJTJGMjAyMzEyMDIlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjMxMjAyVDE2Mjk1N1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWUyODg1ODRmODI2ODAzYTAzMDE1NGU2ZjBhMjViZjNkMWI2YzE4NTM4NjFhOTdlY2YzY2VmZGNmZDUxMTI3OWUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.cqy0MJOjqVGi6mfPHz9n23iWPM9DZrfP6LPafjaDQv8"
        />
      </div>
      </Grid>
    </Grid>
    </Box>
    </>
  );
}

export default Overview;

import { Box, Button, MenuItem, Stack, TextField } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";

function ContactUs() {
  const [name, setName] = useState("");
  const [school, setSchool] = useState({});
  const [reason, setReason] = useState("");
  const [race, setRace] = useState("");
  const [notes, setNotes] = useState("");

  const reasons = [
    "I want to use the power of ice and fire to destroy any who oppose me.",
    "I desire to bend the will of those around me.",
    "I want to unravel the mysteries of Aetherius.",
    "I seek the knowledge of the Elder Scrolls.",
    "I just wanted to see what it looks like inside.",
  ];
  const races = [
    "Dunmer",
    "Altmer",
    "Bosmer",
    "Khajiit",
    "Argonian",
    "Imperial",
    "Breton",
    "Nord",
    "Redguard",
    "Orsimer",
  ];
  
  races.sort()

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

  const handleSubmit = (e) => {
    e.preventDefault();
    const app = {
        name: name,
        race: race,
        reason: reason,
        notes: notes,
        school: school
    }
    const json = JSON.stringify(app)
    axios.post("http://localhost:8080/api/v1/Applications", json, {
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(alert("Your application was a success, please see Faralda for your entrance examination"));
  };

  return (
    <Box
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: '100%' },
      }}
      noValidate
      autoComplete="off"
      onSubmit={handleSubmit}
    >
      <Stack spacing={2} direction="row" sx={{ marginBottom: 4 }}>
        <TextField
          required
          fullWidth
          id="Standard"
          label="Name"
          defaultValue="Name"
          value={name}
          onChange={(e) => {
            setName(e.target.value);
          }}
        />
        <TextField
          id="outlined-select-race"
          fullWidth
          select
          label="Select Race"
          helperText="Please select your race"
          defaultValue={race}
          value={race}
          onChange={(e) => {
            setRace(e.target.value);
          }}
        >
          {races.map((option) => (
            <MenuItem key={option} value={option}>
              {option}
            </MenuItem>
          ))}
        </TextField>
      </Stack>
      <Stack spacing={1} direction="row" sx={{ marginBottom: 4 }}>
      <TextField
        id="outlined-select-reason"
        select
        fullWidth
        label="Select Reason"
        helperText="Please select your reason for joining"
        defaultValue={reason}
        value={reason}
        onChange={(e) => {
          setReason(e.target.value);
        }}
      >
        {reasons.map((option) => (
          <MenuItem key={option} value={option}>
            {option}
          </MenuItem>
        ))}
      </TextField>
      </Stack>
      <Stack spacing={1} direction="row" sx={{ marginBottom: 4 }}>
      <TextField
        id="outlined-multiline-static"
        label="Notes"
        multiline
        fullWidth
        rows={4}
        defaultValue={notes}
        value={notes}
        onChange={(e) => {
          setNotes(e.target.value);
        }}
      />
      </Stack>
      <div>
        <Button variant="contained" type="submit">
          Submit
        </Button>
      </div>
    </Box>
  );
}

export default ContactUs;

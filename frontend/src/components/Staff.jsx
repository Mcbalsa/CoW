import Box from "@mui/material/Box";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import Grid from "@mui/material/Unstable_Grid2";
import axios from "axios";
import React, { useEffect, useState } from "react";

function Staff() {
  const [staff, setStaff] = useState([]);

  const fetchData = async () => {
    await axios
      .get("http://localhost:8080/api/v1/Teachers/GetAll")
      .then((data) => setStaff(data.data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
      <Box sx={{ maxWidth: "100%" }}>
        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          {staff.map((staffMem) => (
            <Grid xs={3}>
              <Card sx={{ maxWidth: 400 }}>
                <CardMedia
                  sx={{ height: 500 }}
                  image={staffMem.photoUrl}
                  title={staffMem.name}
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="div">
                    {staffMem.name}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    {staffMem.title}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Box>
    </>
  );
}

export default Staff;

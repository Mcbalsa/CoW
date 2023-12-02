import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import Accordion from "@mui/material/Accordion";
import AccordionDetails from "@mui/material/AccordionDetails";
import AccordionSummary from "@mui/material/AccordionSummary";
import Typography from "@mui/material/Typography";
import independence from "../Images/independence.png";
import lessons from "../Images/lessons.png";
import library from "../Images/library.png";
import livingQuarters from "../Images/livingQuarters.png";

function Features() {
  const features = [
    {
      name: "The Arcanaeum",
      description:
        "Explore one of Tamriel's most prestigous libraries containing texts dating back to the Second Era",
      img: library,
    },
    {
      name: "Living Quarters",
      description:
        "The College provides every student with comfortable living quaters while they pursue their studies",
      img: livingQuarters,
    },
    {
      name: "Lessons",
      description:
        "Recieve lessons from some of the finest mages in all of Tamriel",
      img: lessons,
    },
    {
      name: "Independence",
      description:
        "The College has always maintained a policy for students to freely pursue their own research.",
      img: independence,
    },
  ];

  return (
    <>
      <div>
        {features.map((feature) => (
          <Accordion>
            <AccordionSummary
              expandIcon={<ExpandMoreIcon />}
              aria-controls="panel1a-content"
              id="panel1a-header"
            >
              <Typography>{feature.name}</Typography>
            </AccordionSummary>
            <AccordionDetails>
              <img
                style={{ height: "720x", width: "1280px" }}
                src={feature.img}
              />
              <Typography>{feature.description}</Typography>
            </AccordionDetails>
          </Accordion>
        ))}
      </div>
    </>
  );
}

export default Features;

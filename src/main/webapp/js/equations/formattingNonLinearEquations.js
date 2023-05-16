const fromCompPart = document.getElementById("fromCompPart");
const sinus = document.getElementById("sinus");
const log = document.getElementById("naturalLogarithm");
const a = document.getElementById("aLabel");
const b = document.getElementById("bLabel");
// const x = document.getElementById("xLabel");
const eps = document.getElementById("epsLabel");

const aLessThanB = document.getElementById("aLessThanB");
const epsHigherThanZero = document.getElementById("epsHigherThanZero");
const xBetweenAB = document.getElementById("xBetweenAB");


katex.render(
    "y = -0.38x^3-3.42x^2+2.51x+8.75",
    fromCompPart
);

katex.render(
    "y = \\sin(x)",
    sinus
);

katex.render(
    "y = \\ln(x)",
    log
);

katex.render("a:",
    a
)

katex.render("b:",
    b
)

// katex.render("x_0:",
//     x
// )

katex.render("\\epsilon:",
    eps
)

katex.render("a < b",
    aLessThanB
)

katex.render("\\epsilon \\geq 0",
    epsHigherThanZero
)

// katex.render("a \\leq x_0 \\leq b",
//     xBetweenAB
// )

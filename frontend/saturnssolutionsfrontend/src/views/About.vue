<template>
  <div class="about">
    <section class="about-section">
      <h1>What is TakeMoney?</h1>
      <p><strong>TakeMoney</strong> is a personal finance app</p>
    </section>
    <section class="columns">
      <section class="founder-section">
        <h1>Meet the founder</h1>
        <div class="break-word">
          <p>
            <strong>Gabriel Nunes</strong> is the TakeMoney founder. He really
            likes technology, games and he loves to help others, nowadays he
            works at YouX Group, he has a large experience in Frontend
            development
          </p>
        </div>
        <div class="social-links">
          <a href="https://www.linkedin.com/in/gabriel-n-150265111"
            ><i class="fab fa-linkedin-in"></i
          ></a>
          <a href="https://www.youtube.com/channel/UC4gD3DdOLveC2r6tSMqNKbw"
            ><i class="fab fa-youtube"></i
          ></a>
          <a href="https://twitter.com/OBilhas"
            ><i class="fab fa-twitter-square"></i
          ></a>
        </div>
      </section>
      <section class="column">
        <div class="break-word">
          <p>
            <strong>Clara Gabrielle</strong> she is the CTO's TakeMoney, she
            works at YouX Group along side Gabriel Nunes
          </p>
        </div>
      </section>
    </section>
  </div>
</template>
<style scoped>
.about {
  display: flex;
  flex-direction: column;
}
.about-section {
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  font-weight: 600;
  margin: 0 auto;
}
.about-section > h1 {
  font-size: 40px;
}
.about-section > p {
  font-size: 17px;
  padding-left: 2.219999999999999rem;
}
.about-section > p > strong {
  color: #d88d00;
}
.columns .founder-section {
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  font-weight: 600;
  margin-left: 2.5rem;
}

.columns .founder-section > h1 {
  font-size: 40px;
  margin-left: 3rem;
}

.columns .founder-section .break-word {
  inline-size: 300px;
  margin-left: 3rem;
  word-wrap: break-word;
}
.columns .founder-section .break-word strong {
  color: #d88d00;
}

.columns .founder-section .social-links {
  display: flex;
  flex-direction: row;
  gap: 1.5rem;
  font-size: 20px;
  margin-left: 3.2rem;
  color: #d88d00;
}

.columns .founder-section .social-links > a {
  text-decoration: none;
  color: #d88d00;
}

.columns {
  margin-top: 10px;
  margin-left: min(10%, 50%);
}

.column .break-word strong {
  color: #d88d00;
}
.column {
  margin-left: min(35%, 55%);
}
.column .break-word {
  inline-size: 300px;
  margin-left: 3rem;
  word-wrap: break-word;
}

@media (max-height: 630px) {
  .columns .column {
    margin-left: min(15%, 55%);
  }
  
}
</style>
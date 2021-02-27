git clone https://github.com/luin/medis.git
cd medis
npm i
npm run pack
# webpack analyzer가 뜨고 난 후 프로세스를 종료하세요 (^C)

node bin/pack.js
# No identity found for signing 에러는 무시하세요
cd dist/out/Medis-mas-x64/
open .

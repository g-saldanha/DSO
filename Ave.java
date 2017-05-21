/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

	public abstract class Ave extends Animal{
		protected int alturaVoo;

		public Ave(int alturaVoo, int tamanhoPasso){
			super(tamanhoPasso);
			this.alturaVoo = alturaVoo;
			this.tamanhoPasso = tamanhoPasso;
		}

		public int getAlturaVoo() {
			return this.alturaVoo;
		}

		public void setAlturaVoo(int alturaVoo) {
			this.alturaVoo = alturaVoo;
		}

		public String voar(){
			return "voo";
		}

		@Override
		public String mover(){
			return "moveu-se";
		}

		@Override
		public String produzirSom() {

			return "produziu Som";
		}

	}

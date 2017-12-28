/**
 * 
 */
package com.cencosud.mobile.web.controller.admin.pdf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author JOSE
 *
 */
public abstract class AbstractITextPdfView extends AbstractView {
	
	public AbstractITextPdfView() {
		setContentType("application/pdf");
	}
	
	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//IE solución: escribir en primera matriz de bytes.
		ByteArrayOutputStream baos = createTemporaryOutputStream();
		
		// Aplicar preferencias y crear metadatos.
		Document document = newDocument();
		PdfWriter writer = newWriter(document, baos);
		prepareWriter(model, writer, request);
		buildPdfMetadata(model, document, request);
		
		//Construir documento PDF.
		document.open();
		buildPdfDocument(model, document, writer, request, response);
		document.close();
		
		// Flush  con la respuesta HTTP.
		writeToResponse(response, baos);
		
	}

	private Document newDocument() {
		// TODO Auto-generated method stub
		return new Document(PageSize.A4);
	}

	private PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
		// TODO Auto-generated method stub
		return PdfWriter.getInstance(document, os);
	}

	protected void prepareWriter(Map<String, Object> model, PdfWriter writer,
			HttpServletRequest request) throws DocumentException {
		// TODO Auto-generated method stub
		writer.setViewerPreferences(getViewerPreferences());
	}

	private int getViewerPreferences() {
		// TODO Auto-generated method stub
		return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
	}

	protected void buildPdfMetadata(Map<String, Object> model, Document document,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	protected abstract void buildPdfDocument(Map<String, Object> model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
